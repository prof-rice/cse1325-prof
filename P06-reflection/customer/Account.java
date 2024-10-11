package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

public abstract class Account {
    public Account() {
        this.accountNumber = nextAccountNumber++;
    } 
    public Account(BufferedReader br) throws IOException {
        this.accountNumber = Integer.parseInt(br.readLine());
        this.nextAccountNumber = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + accountNumber + '\n');
        bw.write("" + nextAccountNumber + '\n');
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public abstract String play(Media media);
    private int accountNumber;
    private static int nextAccountNumber = 1;
}
