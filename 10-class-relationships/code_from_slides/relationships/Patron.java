class Patron extends Person implements Customer {
  public Patron(Library library) {
      this.library = library;
  }
  @Override
  public void pay(double amount) {
  }
  private Library library;
}
