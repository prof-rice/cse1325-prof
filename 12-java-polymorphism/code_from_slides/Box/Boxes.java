class Boxes {
    public static void main(String[] args) {
        // Let's try a couple of rectangular boxes
        Box box1 = new Box( 6,  7,  5);
        Box box2 = new Box(12, 13, 10);
        
        System.out.println("Volume of " + box1 + " is " + box1.volume());
        System.out.println("Volume of " + box2 + " is " + box2.volume());
        
        // Let's try a couple of rectangular boxes
        Box box3 = new TriBox( 6,  7,  5);
        Box box4 = new TriBox(12, 13, 10);
        
        System.out.println("Volume of " + box3 + " is " + box3.volume());
        System.out.println("Volume of " + box4 + " is " + box4.volume());        
    }
}
