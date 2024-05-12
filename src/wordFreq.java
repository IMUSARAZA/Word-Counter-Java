import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class wordFreq {

    private static String[] w = null;
    private static int[] r = null;

    public void start(File file) {
        try {

            int n = 5;
            w = new String[n];
            r = new int[n];

            Path fr = Paths.get(file.toURI());

            BufferedReader br = Files.newBufferedReader(fr);
            String text = "";
            String sz = null;
            while ((sz = br.readLine()) != null) {
                text = text.concat(sz);
            }
            String[] words = text.split(" ");
            String[] uniqueLabels;
            int count = 0;
            uniqueLabels = getUniqLabels(words);
            for (int j = 0; j < n; j++) {
                r[j] = 0;
            }
            for (String l : uniqueLabels) {
                if ("".equals(l) || null == l) {
                    break;
                }
                for (String s : words) {
                    if (l.equals(s)) {
                        count++;
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (count > r[i]) {
                        r[i] = count;
                        w[i] = l;
                        break;
                    }
                }
                count = 0;
            }
            display(n);
        } catch (Exception e) {
            System.err.println("ERR " + e.getMessage());
        }
    }

    public static void display(int n) {
        for (int k = 0; k < n; k++) {
            System.out.println("{"+w[k]+"}"+"\tCount:"+ r[k]+" times");
        }
    }

    private static String[] getUniqLabels(String[] keys) {
        String[] uniqueKeys = new String[keys.length];

        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;

        for (int i = 1; i < keys.length; i++) {
            for (int j = 0; j <= uniqueKeyIndex; j++) {
                if (keys[i].equals(uniqueKeys[j])) {
                    keyAlreadyExists = true;
                }
            }

            if (!keyAlreadyExists) {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;
            }
            keyAlreadyExists = false;
        }
        return uniqueKeys;
    }
}

