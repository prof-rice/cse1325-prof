public class Accumulator <E> {
    private StringBuilder list = new StringBuilder();
    private String separator = "";
    public void add(E addend) {
        list.append(separator + addend);
        separator = ", ";
    }
    public String toString() {
        return list.toString();
    }
}
