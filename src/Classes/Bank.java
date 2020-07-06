package Classes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private static final String NAME = "Mega Bank";
    private static ArrayList<Customer> customerArrayList = new ArrayList<>();
    private Scanner infoScanner = new Scanner(System.in);


    public Bank() throws FileNotFoundException {
        customerCreation();

    }

    private Customer customerCreation() throws FileNotFoundException {
        String firstName;
        String lastName;
        int year;
        int month;
        int day;
        int age;
        LocalDate dob;
        String address;
        String email;
        String phoneNumber;

        Customer newCustomer = new Customer();
        String entered;
        System.out.println("Please enter your first name!");
        entered = infoScanner.nextLine();
        firstName = Verification.verifyName(entered);
        newCustomer.setFirstName(entered);

        System.out.println("Please enter your last name");
        entered = infoScanner.nextLine();
        lastName = Verification.verifyName(entered);


        System.out.println("Please enter the year you were born!");
        entered = infoScanner.nextLine();
        year = Verification.verifyYear(Integer.parseInt(entered));


        System.out.println("Please enter the month you were born. 1-12");
        entered = infoScanner.nextLine();
        month = Verification.verifyMonth(Integer.parseInt(entered));

        System.out.println("Please enter the day you were born");
        entered = infoScanner.nextLine();
        day = Verification.verifyDay(year, month, Integer.parseInt(entered));
        dob = LocalDate.of(year, month, day);

       age = Verification.returnAge(dob);

        address = Verification.verifyAddress();

        System.out.println("Please enter your email address");
        entered = infoScanner.nextLine();
        email = Verification.verifyEmail(entered);

        System.out.println("Please enter your phone number");
        entered = infoScanner.nextLine();
        phoneNumber = Verification.verifyNumber(entered);

        Customer customer = new Customer(firstName, lastName, year, month, day, address, email, phoneNumber);
        Bank.customerArrayList.add(customer);

        FileIO.writeToFile(customer.toString());
        try{
            FileIO.readFromFile();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return newCustomer;
    }
    public String startUp(){
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.println("Hello and welcome to Mega Bank! Please look at our menu options that are listed below!");
        System.out.println("If you are a new member, please enter 1 \n" +
                "If you are a returning member, please enter 2 \n" +
                "If you don't remember your login info, please enter 3 \n" +
                "For all other inquires, please enter 8");
        switch (scanner.nextInt()){
            case 1:
                System.out.println("Hello new member");
        }
        return "";
    }
}
