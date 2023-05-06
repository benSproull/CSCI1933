// Scan.java
// Java IO example with Scanner class
// Scanner class used for "seamless" input without exception handling
// Scanner is a relatively simple way of reading data from the keyboard
// and often used for program testing,
// The Scanner class will be introduced in Lab 2.`
// Revised 9/2020

import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);  // create a scanner instance
        int count = 0, n;
        String words;

        // first Scanner example is reading of ints from the keyboard

        System.out.println("Reading integers...");
        System.out.print("\nValue " + count + "--" +
            "enter an integer followed by <enter/return> (or ^d to stop): ");
        count = count + 1;
        while (s.hasNextInt())  {  // true if more integer tokens
                                   // in this Scanner instance
                                   // hasNextInt() waits for keyboard entry
                                   // if needed
            n = s.nextInt();  // only gets here if an int token present
            System.out.println("You entered: " + n);
            System.out.print("Value " + count + "--" +
                 "enter next integer (or ^d to stop): ");
            count = count + 1;
        }  // while
        System.out.println("\nOK\n\n");

        // Question: does count now represent the number of values entered???

        // second Scanner example is reading of Strings

        s = new Scanner(System.in);  // new Scanner instance
        count = 0;

        System.out.println("Now Strings...");
        System.out.print("\nValue " + count + "--" +
            "enter a string followed by <enter/return> (or ^d to stop): ");
        count = count + 1;

        while (s.hasNext())  {  // true if more String tokens
                                // in this Scanner instance
                                // hasNext() waits for keyboard entry if needed
            words = s.nextLine();  // only gets here if a String token present
            System.out.println("You entered: " + words);
            System.out.print("Value number " + count + "--" +
                "Enter next string: ");
            count = count + 1;  // or count++}
        }  // while
        System.out.println("\nOK\n\n");
    }  // main

} // Scan.java
