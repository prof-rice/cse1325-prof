class Date {
    public static void main(String[] args) {
        for(Month month : Month.values()) {
            System.out.println(month + " (" + month.asInt() + ")");
        }
    }
}
