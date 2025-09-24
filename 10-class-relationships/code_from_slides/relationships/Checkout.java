import java.time.ZonedDateTime;

class Checkout {
  // Association Class: Checkout associates a Book with a Patron
  public Checkout(Book book, Patron patron) {
      this.book = book;
      this.patron = patron;
      this.dueDate = ZonedDateTime.now().plusDays(14);
      this.returnedDate = null;
  }
  public void checkIn() {
      this.returnedDate = ZonedDateTime.now();
  }
  public Double getFine() {
      if(returnedDate == null) return null;
      else if(returnedDate.compareTo(dueDate) > 0) return 2.00;
      else return 0.00;
  }
  
  private Patron patron;
  private Book book;
  private ZonedDateTime dueDate;
  private ZonedDateTime returnedDate;
}
