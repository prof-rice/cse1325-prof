package customer;

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
