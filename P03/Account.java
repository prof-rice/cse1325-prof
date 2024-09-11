public class Account {
    public Account() {
        this.accountNumber = nextAccountNumber++;
    } 
    public int getAccountNumber() {
        return accountNumber;
    }
    public String play(Media media) {
        return "Playing " + media;
    }
    private int accountNumber;
    private static int nextAccountNumber = 1;
}
