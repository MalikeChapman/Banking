package Classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private static final String NAME = "Mega Bank";
    private static ArrayList<Customer> customerArrayList = new ArrayList<>();
    private Scanner infoScanner = new Scanner(System.in);


    public Bank() throws FileNotFoundException {
        /*
        This method is called when the user is new. The purpose of this constructor is to call the customer creation method
        which will go through the process of creating a customer.
         */
        customerCreation();

    }
    public Bank(String username, String pin) throws FileNotFoundException{
        /*
        The purpose of this constructor is for when the user states they are a returning member.
        If they are a returning member, they will enter their username and pin which will then
        be checked against a file to see if it matches a username and pin in the file.
         */

    }

    private Customer customerCreation() throws FileNotFoundException {
        /*
        * This method is used to create a new instance of customer. The method asks the user to input data one at a time.
        * The data is checked by methods created in the Verification class. After all data has been accepted, the method creates a new
        * instance of Customer and writes the data to the file.*/
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
        String username;

        String entered;
        System.out.println("Please enter your first name!");
        entered = infoScanner.nextLine();
        firstName = Verification.verifyName(entered);

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
        customer.setUsername(customer.getEmail());
        customer.setPin();
        Bank.customerArrayList.add(customer);

        FileIO.writeToCustomerFile(customer.toString());
        username = customer.getUsername();
        String pin = customer.getPin();
        FileIO.writeToUsernameAndPinFile(username, pin);
        try{
            FileIO.readFromFile();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return customer;
    }
    public static void startUp(){
        /*
        * This method is used when you first enter the bank. It asks whether you are a new customer, a returning customer, or if you have questions.
        * The method will accept input from the user, then decide the appropriate action. If the user enters invalid input,
        * the system will shut down.*/
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.println("Hello and welcome to Mega Bank! Please look at our menu options that are listed below!");
        System.out.println("If you are a new member, please enter 1 \n" +
                "If you are a returning member, please enter 2 \n" +
                "If you don't remember your login info, please enter 3 \n" +
                "For all other inquires, please enter 3");
        switch (scanner.nextInt()){
            case 1:
                System.out.println("Hello new member. When prompted, please enter your information!");
                try {
                    Bank bank = new Bank();

                } catch (IOException e){

                }
                break;
            case 2:
                System.out.println("Hello valued member, please enter your username, then your unique pin");
                try {
                    scanner.nextLine();
                    System.out.println("Please enter your username");
                    String username = scanner.nextLine();
                    System.out.println("Please enter your pin");
                    String pin = scanner.nextLine();
                    Bank bank = new Bank(username, pin);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.println();
                break;
            default:
                System.out.println("Invalid input, shutting down system. Goodbye!!");
                System.exit(0);
        }

    }
}
