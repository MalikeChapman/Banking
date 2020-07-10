import Classes.Bank;
import Classes.FileIO;
import Classes.Verification;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        boolean loopStatus = true;
        do {
            Bank.startUp();


        } while (loopStatus);







    }
}
