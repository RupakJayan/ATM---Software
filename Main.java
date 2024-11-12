package com.mycompany.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for bank details
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();

        System.out.print("Enter bank location: ");
        String bankLocation = scanner.nextLine();

        // Create a Bank object
        Bank bank = new Bank(bankName, bankLocation);

        // Ask for account number and PIN
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        // Simulate account authorization
        boolean isAuthorized = bank.authorize(accountNumber);
        if (!isAuthorized) {
            System.out.println("Account authorization failed.");
            return; // Exit if authorization fails
        }
        System.out.println("Account authorized successfully.");

        // Create ATM object with account number and balance initialized
        ATM atm = new ATM(pin, 1000.0);  // Assume an initial balance of $1000

        // Initialize MiniStatement object for tracking transactions
        MiniStatement miniStatement = new MiniStatement();

        // Customer actions menu
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (option) {
                case 1: // Withdraw
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);

                    // Add transaction to mini statement
                    Transaction withdrawTransaction = new Transaction(new java.util.Date(), "Withdrawal", withdrawAmount, "TXN" + System.currentTimeMillis());
                    miniStatement.addTransaction(withdrawTransaction);
                    break;

                case 2: // Deposit
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);

                    // Add transaction to mini statement
                    Transaction depositTransaction = new Transaction(new java.util.Date(), "Deposit", depositAmount, "TXN" + System.currentTimeMillis());
                    miniStatement.addTransaction(depositTransaction);
                    break;

                case 3: // Check Balance
                    atm.checkBalance();
                    break;

                case 4: // Mini Statement
                    miniStatement.printStatement();
                    break;

                case 5: // Exit
                    System.out.println("Exiting ATM. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
