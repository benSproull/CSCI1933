import java.util.Scanner;

public class fib {
    public static int fibonacciRecursive(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        } else {
            return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
        }
    }
    public static int fibonacciIterative(int n){
        if (n <= 1){
            return n;
        } else {
            int fib = 0;
            int previousFib = 1;
            for (int i = 0; i < n; i++) {
                int tempFib = fib;
                fib = fib + previousFib;
                previousFib = tempFib;
                //System.out.println(fib);
            }
            return fib;
        }
    }
    public static void main (String[] args){
        //System.out.println(fibonacciRecursive(3));
        //System.out.println(fibonacciRecursive(5));
        //System.out.println(fibonacciIterative(8));
        //System.out.println(fibonacciIterative(10));
        System.out.println("Enter an integer n to get the n'th Fibonacci number:  ");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        System.out.println("The " + n + "'th Fibonacci number using fibonacciRecursive is: " + fibonacciRecursive(n));
        System.out.println("The " + n + "'th Fibonacci number using fibonacciIterative is: " + fibonacciIterative(n));

    }
}
