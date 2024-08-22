class Overflow {
  public static void main(String[] args) {
    int x = Integer.MAX_VALUE-3;
    for(int i=0; i<6; ++i) 
        System.out.println(++x);
  }
}
