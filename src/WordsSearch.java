import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class WordsSearch {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList();
        String [] words=null;
        int wordCount=0;
        int total=0;

        File folder = new File("D:\\OldWindows\\JAVA\\WordCount\\src\\dataset");

        File[] listOfFiles = folder.listFiles();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string to check it's occurrence in the files");
        System.out.println("");
        String checkString = input.nextLine();



        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                Path path = Paths.get(listOfFiles[i].toURI());

                Charset charset = Charset.forName("ISO-8859-1");

                BufferedReader bufferedReader = Files.newBufferedReader(path, charset);

                String curLine;
                wordCount=0;
                while ((curLine = bufferedReader.readLine()) != null) {
                    words=curLine.split("\\s");

                    for (String word: words) {
                        if (word.equalsIgnoreCase(checkString)){
                            wordCount++;
                       }
                    }
                }

                System.out.println("{"+checkString+"}"+" in File "+(i+1)+" : "+wordCount+" times");

                total=total+wordCount;

                if (i == listOfFiles.length - 1) {
                    System.out.println("");
                    System.out.println("Total Occurrence In All Files:" + total);
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}