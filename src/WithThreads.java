import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WithThreads {

        public static void main (String[]args){

            ExecutorService executor = Executors.newFixedThreadPool(10);


            File folder = new File("D:\\OldWindows\\JAVA\\WordCount\\src\\dataset");
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                Path path = Paths.get(listOfFiles[i].toURI());
                executor.submit(() -> countWordsInFile(path));
            }


            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {

            }


            System.out.println("Total Words In All Files: " + total);
        }


        private static void countWordsInFile (Path path){
            ArrayList<String> list = new ArrayList();
            int counter = 0;
            Charset charset = Charset.forName("ISO-8859-1");
            try (BufferedReader bufferedReader = Files.newBufferedReader(path, charset)) {

                String curLine;
                while ((curLine = bufferedReader.readLine()) != null) {
                    list.add(curLine);
                }
                for (String str : list) {
                    String[] words = str.split("\\s");
                    counter = counter + words.length;
                }
                list.clear();
                System.out.println("File: " + path + " - " + counter + " words");

                total += counter;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static int total = 0;
    }

