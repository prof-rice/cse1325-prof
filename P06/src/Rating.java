public class Rating {
    public Rating(int stars, Comment review) {
        if(stars < 1 || stars > 5)
            throw new IllegalArgumentException("Invalid Rating values");
        this.stars = stars;
        this.review = review;
    }
    public int getStars() {
        return stars;
    }
    public Comment getReview() {
        return review;
    }
    @Override
    public String toString() {
        return star.repeat(stars) + noStar.repeat(5-stars);
    }
    private static final String star = Character.toString(0x2605); // 0x272D);
    private static final String noStar = Character.toString(0x2606); //0x2729);
    private int stars;
    private Comment review;
}
