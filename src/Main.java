//Main.java  - Entry point for ATM Simulation
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //Create a sample account with an initial balanace and pin
        Account userAccount = new Account(8000, 9876);

        System.out.println("================================");
        System.out.println("      Welcome to ATM System     ");
        System.out.println("================================");

        //Pin Validation
        System.out.println("Enter your PIN: ");
        int pin = sc.nextInt();

        if (userAccount.validatePin(pin)) {
            System.out.println("Login Success..");
            ATM atm = new ATM(userAccount);
            atm.showMenu();
        } else {
            System.out.println("Invalid Pin! Exiting...");
        }
    }
}