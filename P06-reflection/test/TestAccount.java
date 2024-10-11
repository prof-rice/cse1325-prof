package test;

import customer.Account;
import customer.Unlimited;

public class TestAccount {
    public static void main(String[] args) {
        int result = 0;
        
        // Verify that the first account number created is ``1``, and the second account number is ``2``.
        for(int expected = 1; expected < 3; ++expected) {
            Account account = new Unlimited();
            int actual = account.getAccountNumber();
            if(actual != expected) {
                System.err.println("FAIL: Expected account number " + expected + '\n'
                                 + "      Actual   account number " + actual);
                result = 1;
            }
        }

        if(result != 0) System.err.println("\nFAIL: Error code " + result);
        System.exit(result);
    }
}

