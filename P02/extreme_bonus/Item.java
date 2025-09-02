public class Item implements Comparable<Item> {
    private String task;
    private int priority;
    public Item(String task, int priority) {
        this.task = task;
        this.priority = priority;
    }
    public boolean isPriority(int priority) {
        return this.priority == priority;
    }
    @Override
    public int compareTo(Item item) {
        return priority - item.priority;
    }
    @Override
    public String toString() {
        return priority + " " + task;
    }
}

