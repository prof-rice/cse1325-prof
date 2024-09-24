public class WaterFlea extends Bug {
    public WaterFlea(Stage stage) {
        super(stage);
        System.out.println("WaterFlea is now " + stage); // NOT on exam
    }
    @Override
    public void nextStage() {
        stage = Stage.ADULT;
        System.out.println("WaterFlea is now " + stage); // NOT on exam
    }
    public void swim(double depth) {
        if(depth < 0) throw new IllegalArgumentException("Can't fly!");
        System.out.println("Swimming WaterFlea");
    }
}
