import java.io.*;
import java.net.*;
import java.util.*;

public class FileOperator {

    private File myFile;
    private Scanner fileReader;
    private URL myUrl;

    public FileOperator(String url, boolean isOnline) throws IOException {
        if (isOnline) {
            setUrl(url);
        } else {
            setFile(url);
        }
    }

    public FileOperator(String f) throws IOException {
        setFile(f);
    }

    public void setFile(String f) throws IOException {
        myFile = new File(f);
        fileReader = new Scanner(myFile);
    }

    public void setUrl(String urlString) throws IOException {
        myUrl = new URL(urlString);
        fileReader = new Scanner(myUrl.openStream());
    }

    public String readLine() {
        if (fileReader.hasNextLine()) {
            return fileReader.nextLine();
        } else {
            return "NoLine";
        }
    }

    public static void main(String[] args) {
        try {
            FileOperator fo = new FileOperator("https://people.sc.fsu.edu/~jburkardt/data/csv/airtravel.csv", true);
            String line;
            while (!(line = fo.readLine()).equals("NoLine")) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
