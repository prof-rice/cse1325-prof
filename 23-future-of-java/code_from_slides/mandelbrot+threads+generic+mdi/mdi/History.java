package mdi;

import java.util.Deque;
import java.util.LinkedList;

public class History <E> {
    @SafeVarargs
    public History(int maxSize, E... entries) {
        this.maxSize = maxSize;
        history = new LinkedList<>();
        for(var e : entries) add(e);
    }
    public void add(E item) {
        history.addFirst(item);
        while(history.size() > maxSize)
            history.removeLast();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("History\n=======\n");
        for(var e : history.toArray()) {
            if(e != null && !e.toString().isEmpty())
                sb.append(e.toString() + '\n');
        }
        return sb.toString();
    }

    private Deque<E> history;
    private int maxSize;
}
