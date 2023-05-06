

import java.util.Scanner;

public class HistogramApp {


    public static void main(String[] args){

        Scanner myScanner = new Scanner(System.in);
        int lowerbound;
        int upperbound;
        int num;
        String command = "";
        System.out.print("Enter lowerbound: ");
        lowerbound = myScanner.nextInt();
        System.out.print("Enter upperbound: );
        upperbound = myScanner.nextInt();
        System.out.println("Your bounds are: " + lowerbound + "-" + upperbound);
        System.out.println("Options \n add - to add a number to the histogram \n print - prints out the histogram \n quit - to terminate the program");
        Histogram hist = new Histogram(lowerbound,upperbound);
        command = myScanner.nextLine();
        while (!command.equals("quit")){
            command = myScanner.nextLine();

            
            if (command.equals("add")){
                System.out.print("Enter a number:  ");
                num = myScanner.nextInt();

                if (num < lowerbound || num > upperbound){
                    System.out.println(num + " is not in range!!");
                } else {
                    hist.add(num);

                }
            }
            if (command.equals("print")) {
                
                System.out.println(hist);
            }

        }
    }
}
