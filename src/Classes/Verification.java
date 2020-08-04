package Classes;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {
    public static String verifyName(String name){
        /*
        This method is used to take an input and verify if the String is acceptable. If the string isn't valid, the user will have
        3 chances to correct it or the system will shut them out.
         */
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
        if (count == 0){
            return "";
        }
        return name;

    }
    public static boolean hasDigits(String name){
        /*
        This method returns a true value if the string has any digits in it,
        or it will return false when there's no digits in the name.
         */
        return (name.matches(".*\\d"));
    }
    public static int verifyYear(int year){
        /*
        This method checks to see if the year that was entered is before this year and after the year 1900.
        If valid, the year will be returned. If the year is invalid, another helper method is called to retry to enter the year.
         */
        if (year > LocalDate.now().getYear() || year < 1900){
            helperVerifyYear();
        }
        return year;
    }
    public static int helperVerifyYear(){
        /*
        Gives the user three chances to enter a valid year.
         */
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
        /*
        This method checks to see if a valid month was entered. The month will be a int value and represents 0-11. The system is zero based
        like an array. If the value is invalid the system will give three chances before shutting down.
         */
        if (month < 1 || month > 12){
            System.out.println("Error invalid Month entered!!");
            Scanner scanner = new Scanner(System.in);
            for(int i = 0; i < 3; i++){
                System.out.println("Please enter the month you were born as a number!");
                month = scanner.nextInt();
                scanner.nextLine();
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
        /*
        This method checks to see if the day of the month entered is between the limits of that month.
        The month and year is used to check if the year might be a leap year.
        The method uses an instance of the Calendar class to check the months maximum and minimum days.
         */
        LocalDate dob = LocalDate.of(year, month, day);
        if (day < 1 || day > dob.lengthOfMonth())
        {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 3; i++){
                System.out.println("Please enter a valid day of the month! You have " + (3 - i + 1) + " chances remaining!");
                day = scanner.nextInt();
                if (day < 1|| day > dob.lengthOfMonth())
                {
                    continue;
                }
                else
                    {
                    break;
                }
            }
            return day;
        }
        else

            return day;
    }
    public static int returnAge(LocalDate dob){
        /*
        This method checks the age of the user. It subtracts the current year from the year of birth.
        If the users dob matches the local month and day his age is the subtracted value.
        If not, his age is the subtracted current year and the year born minus 1.
         */
        if ((dob.getMonth() == LocalDate.now().getMonth() || dob.getMonthValue() > LocalDate.now().getMonthValue()) && dob.getDayOfMonth() >= LocalDate.now().getDayOfMonth() ){
            return (LocalDate.now().getYear() - dob.getYear());
        }
        else
            return ((LocalDate.now().getYear() - dob.getYear()) - 1);

    }
    public static String verifyNumber(String number){
        /*
        This method checks a input from the user to see if its a valid length for a phone number.
        If the length is valid and it only contains digits, the method will format it into.
        +1 (999) 999-999
        The checker uses a regular expression that splits the entered String into a 3-3-4 phone number format
         */
        if (verifyNumberHelper(number)){
            number = number.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", " +1 ($1) $2-$3");
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
            }
            return number;
        }
    }
    public static boolean verifyNumberHelper(String number){
        /*
        Helper method for the verify number that checks if the string is of sufficient length and that it contains only numeric values.
        If it doesn't, the method will return false.
         */
        if (number.matches("\\d.*") && number.length() == 10){
            return true;

        }
        else
            return false;

    }
    public static String verifyAddress(){
        /*
        Method that asks the user to input their address by parts.
        The address will be first the street address,
        city of the state you live in will be next,
        State that you live in will be after,
        Lastly will be your zipcode.
        After that is done, the Stringbuilder type will be transformed into a string and then returned.
         */
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
        return address;
    }
    public static String verifyEmail(String email){
        /*
        This method is used to check if a user has entered a valid format for an email.
        The user input is checked using a regular expression.
         The regular expression checks if the email contains numbers, letters, or special symbols.
         If the input is valid, it will return the email as a string.
         The user has 3 opportunities to provide a valid email address.
         */
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
        /*
        This helper method is used to check if a valid email matches the logic.
        If the email doesn't contain this, the value returned will be false.
         */
        if (email.matches("([0-9]|[a-z]|[\\w])+@([0-9]|[a-z])+.com"))
        {
            return true;
        }
        else return false;
    }
    public static String usernameVerification(String email){
        /*
        This method asks a user if they want to make their email their username or if they want to make a completely different/unique username.
        If the user adds invalid input when asked, their email will automatically be assigned as their username.
         */
        System.out.println("Would you like to make your email your username?" +
                "\n If yes, please enter y." +
                "\n If not, please enter n");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.length() > 1){
            System.out.println("Invalid input, your email will automatically be your username! You can change this later in your settings.");
            return email;
        }
        else if(answer.equalsIgnoreCase("y"))
        {
            return email;
        }
        else if (answer.equalsIgnoreCase("n"))
        {
            System.out.println("Please enter your username! It has to be at least length of 7 but max 15");
            answer = scanner.nextLine();
            if (usernameVerificationHelper(answer)){
                return answer;
            }
            else {
                System.out.println("Invalid input, Please correct! Username has to be at least length 7 but max length is 15");
                answer = scanner.nextLine();
                if (usernameVerificationHelper(answer)) {
                    return answer;
                }

            }
        }
        return "email not set";
    }
    public static boolean usernameVerificationHelper(String user){
        /*
        This helper method is used to verify that the string entered by the user is at least of length 7, but maximum length is 15.
        If the string entered matches the pattern the value returned will be true.
        The Pattern class was used to make a Regular expression.
        Matcher class was used to check if the string matches the pattern.
        The return value matches if the pattern matched or not.
         */
        Pattern pattern = Pattern.compile("([a-z]|[0-9]|\\W){7,15}");
        Matcher matcher = pattern.matcher(user);
        boolean resultOfPattern = matcher.matches();
        if(resultOfPattern){
            return true;
        }
        else
            return false;
    }
    public static String userPinVerification(){
        System.out.println("Please enter a unique six digit pin." +
                "\n This pin should be comprised of only numbers.");
        Scanner scanner = new Scanner(System.in);
        String pin = scanner.nextLine();
        if (pinVerification(pin))
        {
            return pin;
        }
        else {
            System.out.println("Invalid pin entered! Please try again");
            boolean flag = true;
            while(flag){
                System.out.println("Please re-enter a valid pin" +
                        "\n The pin should be comprised of all digits and the pin should be 6 digits long");
                pin = scanner.nextLine();
                if (pinVerification(pin))
                {
                    break;
                }
                else {
                    System.out.println("Invalid pin entered!");
                }
            }
            return pin;
        }
    }
    public static boolean pinVerification(String pin){
        /*
        This method tests to see if the pin entered is of length 6 and that it contains only digits
         */
        if (pin.matches("\\d{6}") && pin.length() == 6)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public static LocalDate localDateCreater(int year, int month, int day){
        return LocalDate.of(year, month, day);
    }




}
