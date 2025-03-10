import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Account {
    private double balance;
    private int pin;
    private static final String TRANSACTION_FILE = "transactions.txt"; // File to store transactions

    // Constructor
    public Account(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
        
        // Ensure the transaction file exists
        try {
            File file = new File(TRANSACTION_FILE);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error initializing transaction file.");
        }
    }

    // Method to validate PIN
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Method to get account balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
            saveTransaction("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            saveTransaction("Withdrew $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount!");
            return false;
        }
    }

    // Method to save transaction in file
    private void saveTransaction(String transaction) {
        try (FileWriter fileWriter = new FileWriter(TRANSACTION_FILE, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(transaction);
        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }

    // Method to display transaction history
    public void showTransactionHistory() {
        System.out.println("\n====== Transaction History ======");
        try (Scanner scanner = new Scanner(new File(TRANSACTION_FILE))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("No transaction history found.");
        }
    }
}
