public class ArrayListTimeTaggedGeneric {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Working...");
        TaggedArrayList<String> list = new TaggedArrayList<>();
        list.add("The answer is ");
        Thread.sleep(1000 + (long)(Math.random() * 5000));
        list.add("forty-two");
        System.out.println("done!");
        // Haven't covered iterators yet, so 3-term for
        for (int i=0; i<list.size(); ++i) {  
            System.out.println(list.toString(i));
        }
    }
}

