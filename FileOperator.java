import java.io.*;
import java.util.*;

public class FileOperator {
    private File myFile;
    private Scanner fileReader;
    public FileOperator(string f){
        setFile(f);
    }
    public void setFile(string f) throws IOException{
            myFile = new File(f);
            fileReader = new Scanner(myFile);
    }
    public String readLine(){
        return fileReader.nextLine();
    }

}