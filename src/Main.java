import Classes.Bank;
import Classes.FileIO;
import Classes.Verification;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        boolean loopStatus = true;
        String test = "7182123456";
        String pattern = "\\d.*";
        if (test.matches(pattern) && test.length() == 10) {
            System.out.println("Test Works!!");
            String answer = test.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "+1 ($1) $2-$3");
            System.out.println(answer);

        }
        else {
            System.out.println("Did it wrong");
        }
        //System.out.println(Verification.verifyAddress());
        String email = "ash17@gmail.com";
        if (Verification.verifyEmailHelper(email)){
            System.out.println("Success");
        }
        else {
            System.out.println("Needs to be fixxed");
        }
        do {


        } while (loopStatus);
    }
}
