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
        String FileName = SafeInput.getNonZeroLenString(in,"Please enter the file name");
        String WorkingDir = System.getProperty("user.dir") + "/src";
        String FullFileName = WorkingDir + "/" + FileName + ".csv";
        //Check that the file exists
        try {
            File DataFile = new File(FullFileName);
            if(DataFile.createNewFile()){
                System.out.println("File created: " + FullFileName);
            }
            else{
                System.out.println("File already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred");
        }

        do{
            String first, last, id, email, yob;
            first  = SafeInput.getNonZeroLenString(in,"Please enter the first name");
            last  = SafeInput.getNonZeroLenString(in,"Please enter the last name");
            id = SafeInput.getNonZeroLenString(in,"Please enter the ID number");
            id = String.format("%06d", Integer.parseInt(id));
            email = SafeInput.getNonZeroLenString(in,"Please enter your email");
            yob = SafeInput.getNonZeroLenString(in,"Please enter the year of birth");
            yob  = String.format("%04d", Integer.parseInt(yob));
            String Record = String.join(", ", first, last, id, email, yob);
            Records.add(Record);
            for(int i = 0; i < Records.size(); i++){
                System.out.println(Records.get(i));
            }
            //Write to file after each record collection
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(FullFileName, true));) {
                bw.write(Record);
                bw.newLine();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("An error occurred");
            }


            Cont = SafeInput.getYNConfirm(in,"Would you like to add another record");
        }while(Cont);
        System.out.println("\n All records added to: " + FullFileName);










    }
}
