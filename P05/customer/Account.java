package customer;

import product.Media;

public abstract class Account {
    public Account() {
        this.accountNumber = nextAccountNumber++;
    } 
    public int getAccountNumber() {
        return accountNumber;
    }
    public abstract String play(Media media);
    private int accountNumber;
    private static int nextAccountNumber = 1;
}
