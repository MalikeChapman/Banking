package Classes;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Verification {
    public static String verifyName(String name){
        int count = 3;
        boolean flag = false;
        while(count > 0) {
            if (hasDigits(name)){
                System.out.println("The name you have entered is invalid, you have " + count + " chances left!");
                System.out.println("Please enter a valid name!");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                name = input;
                count--;
            }
            else
                break;
        }
        return name;

    }
    public static boolean hasDigits(String name){
        return (name.matches(".*\\d"));
    }
    public static int verifyYear(int year){
        if (year > LocalDate.now().getYear() || year < 1900){
            helperVerifyYear();
        }
        return year;
    }
    public static int helperVerifyYear(){
        int count = 3;
        int year = 0;
        for (int i = 0; i < 3; i++){
            Scanner scanner = new Scanner(System.in);
            year = scanner.nextInt();
            if (year > LocalDate.now().getYear() || year < 1900){
                continue;
            }
            else
                break;

        }
        return year;

    }
    public static int verifyMonth(int month){
        if (month < 1 || month > 12){
            System.out.println("Error invalid Month entered!!");
            Scanner scanner = new Scanner(System.in);
            for(int i = 0; i < 3; i++){
                System.out.println("Please enter the month you were born as a number!");
                month = scanner.nextInt();
                if (month < 1 || month > 12){
                    continue;
                }
                else
                    break;
            }
            return month;
        }
        else
            return month;
    }
    public static int verifyDay(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        if (day < calendar.getActualMinimum(month - 1) || day > calendar.getActualMaximum(month - 1))
        {

            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 3; i++){
                System.out.println("Please enter a valid day of the month! You have " + (3 - i + 1) + " chances remaining!");
                day = scanner.nextInt();
                if (day < calendar.getActualMinimum(month - 1) || day > calendar.getActualMaximum(month - 1))
                {
                    continue;
                }
                else{
                    scanner.close();
                    break;
                }

            }
            return day;
        }
        else
            return day;


    }
    public static int returnAge(LocalDate dob){
        if (dob.getMonth() == LocalDate.now().getMonth() && dob.getDayOfMonth() == LocalDate.now().getDayOfMonth()){
            return (LocalDate.now().getYear() - dob.getYear());
        }
        else
            return ((LocalDate.now().getYear() - dob.getYear()) - 1);

    }
    public static String verifyNumber(String number){
        if (verifyNumberHelper(number)){
            number = number.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", " +1 ($2) $3-$4");
            return number;

        }
        else {
            System.out.println("Error invalid input!!");
            for(int i = 0; i < 3; i++){
                System.out.println("Please enter your ten digit phone number!");
                Scanner scanner = new Scanner(System.in);
                String test = scanner.nextLine();
                if (verifyNumberHelper(test)){
                    test = test.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "+1 ($1) $2-$3");
                    number = test;
                    break;
                }
                scanner.close();
            }
            return number;
        }
    }
    public static boolean verifyNumberHelper(String number){
        if (number.matches("\\d") && number.length() == 10){
            return true;

        }
        else
            return false;

    }
    public static String verifyAddress(){
        System.out.println("Please enter your Street Address!");
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(scanner.nextLine());
        stringBuilder.append(", ");
        System.out.println("Please enter your city");
        stringBuilder.append(scanner.nextLine());
        stringBuilder.append(", ");
        System.out.println("Please enter your state");
        stringBuilder.append(scanner.nextLine());
        stringBuilder.append(", ");
        System.out.println("Please enter your zipcode");
        stringBuilder.append(scanner.nextLine());
        String address = stringBuilder.toString();
        scanner.close();
        return address;
    }
    public static String verifyEmail(String email){
    if(verifyEmailHelper(email)){
        return email;
    }
    else {
        for(int i = 0; i < 3; i++){
            System.out.println("Error invalid email entered");
            Scanner scanner = new Scanner(System.in);
            String  verifiedEmail = scanner.nextLine();
            if (verifyEmailHelper(verifiedEmail)){
                email = verifiedEmail;
                break;
            }
            else
            {
                continue;
            }
        }
        return email;
    }
    }
    public static boolean verifyEmailHelper(String email){
        if (email.matches("([0-9]|[a-z]|[\\w])+@([0-9]|[a-z])+.com"))
        {
            return true;
        }
        else return false;
    }




}
