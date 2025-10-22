public class TestEquals {
    public static void main(String[] args) {
        Box box = new Box(3, 4, 5);
        TriBox tribox = new TriBox(3, 4, 5, TriBox.Shape.Equilateral);
        System.out.println("" + box + 
                               (box.equals(tribox) ? " == " : " != ") + 
                                tribox);
        System.out.printf("Box hashcode = %x\nTriBox hashcode = %x\n",
            box.hashCode(),
            tribox.hashCode());
    }
}
