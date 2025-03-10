// ATM.java - Handles ATM operations
import java.util.Scanner;

public class ATM {
    private Account userAccount;
    private Scanner scanner;

    // Constructor
    public ATM(Account account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    // ATM Menu
    public void showMenu() {
        int option = 0;
        do {
            System.out.println("\n======== ATM Menu ========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            // Error handling for invalid input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }
            
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    userAccount.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (option != 5);
    }

    // Check Balance Function
    private void checkBalance() {
        System.out.println("Your current balance is: $" + userAccount.getBalance());
    }

    // Deposit Money Function
    private void depositMoney() {
        System.out.print("Enter amount to deposit: $");
        
        // Error handling for invalid input
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount! Please enter a valid number.");
            scanner.next(); // Clear invalid input
            return;
        }

        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    // Withdraw Money Function
    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: $");
        
        // Error handling for invalid input
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount! Please enter a valid number.");
            scanner.next(); // Clear invalid input
            return;
        }

        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }
}
