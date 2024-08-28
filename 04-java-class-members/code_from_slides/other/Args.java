class Args {
  public static void main(String[] args) {
      System.out.println("This program has " + args.length + " arguments");
      for(String s : args) 
        System.out.println("  " + s);
  }
}
