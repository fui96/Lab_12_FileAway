import java.io.*;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.Writer;


public class DataSaver {
    public static void main(String[] args) {
        Boolean Cont = true;
        Scanner in = new Scanner(System.in);
        //Get info
        ArrayList<String> Records = new ArrayList<>();
        do{
            String first, last, id, email, yob;
            first  = SafeInput.getNonZeroLenString(in,"Please enter the first name");
            last  = SafeInput.getNonZeroLenString(in,"Please enter the last name");
            id = SafeInput.getNonZeroLenString(in,"Please enter the ID number");
            email = SafeInput.getNonZeroLenString(in,"Please enter your email");
            yob = SafeInput.getNonZeroLenString(in,"Please enter the year of birth");
            Records.add(first + ", " + last + ", " + id + ", " + email + ", " + yob);
            Cont = SafeInput.getYNConfirm(in,"Would you like to add another record");
        }while(Cont);
       // Select file or create file for data

       String FileName = SafeInput.getNonZeroLenString(in,"Please enter the file name");

       try{
           File DataFile = new File(FileName);
           if(DataFile.exists()){
               for(int i = 0; i < Records.size(); i++){
                   FileWriter TheWriter = new FileWriter(DataFile);

                   TheWriter.write(Records.get(i));

               }
           }
       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("An error occurred");
       }



    }
}
