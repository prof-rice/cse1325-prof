class Checkout {
  // Association Class: Checkout associates a Book with a Patron
  public Checkout(Patron patron, Book book) {
      this.patron = patron;
      this.book = book;
  }
  
  private Patron patron;
  private Book book;
}
