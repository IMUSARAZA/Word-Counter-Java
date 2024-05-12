import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {

        System.out.println("Enter 1 to get count of all the words in files");
        System.out.println("Enter 2 to search specific string frequency in all files");
        System.out.println("Enter 3 to get top 5 most frequent string in all files");

        Scanner input = new Scanner(System.in);

        int select = input.nextInt();

        switch (select){

            case 1:
                System.out.println("(1) With Threads (2) Without Threads");
                Scanner input2 = new Scanner(System.in);
                int choice = input2.nextInt();
                if (choice==1){
                    WithThreads.main(args);
                }
                else {
                    WordsCount.main(args);
                }
                break;
            case 2:
                WordsSearch.main(args);
                break;
            case 3:
                CountFreq.main(args);
            default:
                System.out.println("Wrong selection");

        }


    }






}
