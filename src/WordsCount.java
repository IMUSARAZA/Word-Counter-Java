import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class WordsCount {
    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList();

        int counter=0;
        int total=0;


        File folder = new File("D:\\OldWindows\\JAVA\\WordCount\\src\\dataset");

        File[] listOfFiles = folder.listFiles();

        wordFreq wordFreq = new wordFreq();


        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                Path path = Paths.get(listOfFiles[i].toURI());

                Charset charset = Charset.forName("ISO-8859-1");

                BufferedReader bufferedReader = Files.newBufferedReader(path,charset);

                String curLine;
                while ((curLine = bufferedReader.readLine()) != null) {
                    list.add(curLine);
                }

                bufferedReader.close();
//                total = total + counter;


                for (String str : list) {
                    String[] words = str.split("\\s");
                    counter = counter + words.length;
                }

                System.out.println("File" + " " + (i + 1) + ": " + counter+" words");


                    total=total+counter;
                    System.out.println("");
                counter = 0;

                list.clear();
            }
            System.out.println("Total Words In All Files:" + total);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
