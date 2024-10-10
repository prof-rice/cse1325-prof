import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class GroceryCart {
    public GroceryCart() {
         items = new TreeMap<>();
    }
    public GroceryCart(BufferedReader br) throws IOException {
        this();
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) {
            String type = br.readLine();
            Long key = Long.parseLong(br.readLine());
            if(type.equals("fruit")) items.put(key, new Fruit(br));
            else if(type.equals("dairy")) items.put(key, new Dairy(br));
            else throw new RuntimeException("Invalid item type: " + type);
        }
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + items.size() + '\n');
        Set<Long> keys = items.keySet();
        Iterator<Long> it = keys.iterator();
        while(it.hasNext()) {
            Long key = it.next();
            Item item = items.get(key);
            if(item instanceof Fruit) bw.write("fruit\n");
            else if (item instanceof Dairy) bw.write("dairy\n");
            else throw new RuntimeException("Invalid item type: " + item);
            bw.write("" + key + '\n');
            item.save(bw);
        }
    }
    public void addItem(long upc, Item item) {
        items.put(upc, item);
    }
    public void removeItem(long upc) {
        items.remove(upc);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("        Receipt\n\n");
        Set<Long> keys = items.keySet(); // Set keys = is also OK, but NOT Set<>
        Iterator<Long> it = keys.iterator();
        while(it.hasNext()) {
            long upc = it.next();
            sb.append(String.format("%15d", upc)
                    + items.get(upc) + '\n');
        }
        return sb.toString();
    }
    private Map<Long,Item> items;
}
