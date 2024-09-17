package customer;

import product.Media;

public class Alacarte extends Account { 
    public void buyPoints(int points) {
        pointsRemaining += points;
    }
    public int getPointsRemaining() {
        return pointsRemaining;
    }
    @Override
    public String play(Media media) {
        int points = media.getPoints();
        if(points > pointsRemaining)
            return "Buy more points: Requires " + points 
                 + " points, you have " + pointsRemaining;
        pointsRemaining -= points;
        return "Playing " + media;
    }
    private int pointsRemaining = 0;
}
