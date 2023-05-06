import java.util.Scanner;

public class max {
    public static int recursiveMaxDigit(int num) {
        if (num <= 9 && num >= 0){
            return num;
        } else {
            int digit = (num%10);
            int max = recursiveMaxDigit(num / 10);
            int max1 = Math.max(digit, max);
            return max1;

        }

    }
    public static int iterativeMaxDigit(int num) {
        int max = 0;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            if (digit > max) {
                max = digit;
            }
        }
        return max;
    }
    public static void main (String[] args) {
        System.out.println("Enter a number to find the max digit");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        System.out.println("The max digit for: " + n +" is: "+ recursiveMaxDigit(n));
        System.out.println("The max digit for: " + n +" is: "+ iterativeMaxDigit(n));

    }
}
