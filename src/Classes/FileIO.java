package Classes;

import java.io.*;

public class FileIO {
    public static String fileName = "Customer_Info.txt";
    public static void writeToFile(String info) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName));
        printWriter.println(info);
        printWriter.close();
    }
    public static void readFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.readLine() != null){
            System.out.println(bufferedReader.readLine());

        }

    }

}
