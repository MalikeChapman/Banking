package Classes;

import java.io.*;

public class FileIO {
    public static String customerFileName = "Customer_Info.txt";
    public static String usernameFileName = "Username_And_Pin.txt";
    public static void writeToCustomerFile(String info) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(customerFileName));
        printWriter.println(info);
        printWriter.close();
    }
    public static void readFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(customerFileName));
        String line = bufferedReader.readLine();
        while ( line != null){
            System.out.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

    }
    public static void writeToUsernameAndPinFile(String username, String pin){
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(usernameFileName));
            printWriter.print(username + ", ");
            printWriter.print(pin);
            printWriter.println();
            printWriter.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getStackTrace());
        }


    }
    public static boolean findUsernameFromFile(String username, String pin){
        /*
        This method is used to check if the values entered match a username and pin pair from the file.
        If the values are found in the file, it will return true, false otherwise.
         */
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(usernameFileName));
            String lineFromFile = bufferedReader.readLine();
            String[] usernameAndPinArray = lineFromFile.split(",");
            if (username.equals(usernameAndPinArray[0]) && pin.equals(usernameAndPinArray[1]))
            {
                return true;
            }

        } catch (FileNotFoundException e){

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
