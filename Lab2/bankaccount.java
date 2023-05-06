import java.util.Scanner;

public class BankAccount {
    private String name;
    private String password;
    double balance;



    public void withdraw(String enteredPassword, double amount){
        // Need the correct password to open account
        if (password.equals(enteredPassword) && balance >= amount) {
            balance = balance - amount;

        }
    }
    public void deposit(String enteredPassword, double amount) {
        if (password.equals(enteredPassword)){
            balance = balance + amount;
        }
    }
    public static void main(String[] args){
        BankAccount myAccount = new BankAccount("Java", "CSCI1933 rules!", 1000);
        BankAccount otherAccount = new BankAccount("Java", "CSCI1933 rules!", 100);
        System.out.println("Type something, then press enter");
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        System.out.println("You input " + input);
        if (myAccount.password.equals(input)){
            System.out.println("My account's balance is: " + myAccount.getBalance("CSCI1933 rules!"));
            System.out.println("Enter password for other account");
            Scanner otherScanner = new Scanner(System.in);
            String otherInput = otherScanner.nextLine();
            myAccount.transfer(otherAccount,"CSCI1933 rules!", 100);
        } else {
            //System.out.println("Your balance is: -1");
            System.out.println("My account's balance is: " + myAccount.getBalance("CSCI1933 rules!"));
            System.out.println("Other account's balance is: " + otherAccount.getBalance("CSCI1933 rules!"));
        }

        myAccount.password = "CSCI1933 rules!";
        myAccount.deposit("CSCI1933 rules!", 0);



        //myAccount.getBalance("CSCI1933 rules!");
    }
    public void transfer(BankAccount other, String enteredPassword, double amount){
        if (password.equals(enteredPassword) && (this.balance > amount)){
            this.withdraw(enteredPassword, amount);
            other.deposit(enteredPassword, amount);
            System.out.println("my account: " + this.balance);
            System.out.println("other account: " + other.balance);
        } else {
            System.out.println("my account: " + this.balance);
            System.out.println("other account: " + other.balance);
        }
    }
    public BankAccount(String initName, String initPass, double initBalance) {
        this.name = initName;
        this.password = initPass;
        this.balance = initBalance;
    }
    public double getBalance(String enteredPassword) {
        if (password.equals(enteredPassword)) {
            return balance;
        } else {
            return -1;
        }
    }
    public boolean setPassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            password = newPassword;
            return true;
        } else {
            return false;
        }
    }

    
}
