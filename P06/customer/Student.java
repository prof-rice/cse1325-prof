package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

public class Student {
    public Student(String name, int id, String email, boolean unlimited) {
        if(email.endsWith("@uta.edu") || email.endsWith("@mavs.uta.edu")) {
            this.name = name;
            this.id = id;
            this.email = email;
            this.account = unlimited ? new Unlimited() : new Alacarte();
        } else {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }
    }
    public Student(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.id = Integer.parseInt(br.readLine());
        this.email = br.readLine();
        String accountType = br.readLine();
        if(accountType.equals("customer.Unlimited")) this.account = new Unlimited(br);
        else if(accountType.equals("customer.Alacarte")) this.account = new Alacarte(br);
        else throw new IOException("Invalid Account type for Student " + this.name + ": " + accountType);
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write("" + id + '\n');
        bw.write(email + '\n');
        bw.write(account.getClass().getName() + '\n');
        account.save(bw);
    }
    public String requestMedia(Media media) {
        return account.play(media);
    }
    public Account getAccount() {
        return account;
    }
    @Override
    public String toString() {
        return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ')';
    }
    private String name;
    private int id;
    private String email;
    private Account account;
}
