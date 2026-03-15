import java.util.*;
import java.io.*;

public class CreateSampleTests {
    public static void WriteFiles(int numOfFolders){
        FileWriter file = null;

        try {
            for (int i = 1; i < 11; i++) {
                file = new FileWriter(new File(String.format("sample_%d_" + i + ".txt", numOfFolders)));
                //BufferedWriter buffer = new BufferedWriter(file);

                for (int j = 1; j <= numOfFolders; j++){
                    int r = new Random().nextInt(1000001);
                    String line = String.valueOf(r);
                    file.write(line + "\n");
                }
                file.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    } // Write files
    public static void main(String[] args){

        WriteFiles(100);
        WriteFiles(500);
        WriteFiles(1000);

    }// main
} // CreateSampleTests
