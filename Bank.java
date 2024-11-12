package com.mycompany.atm;

import java.util.Scanner;

public class Bank {
    private String bankName;
    private String bankLocation;

    // Constructor that initializes the bank name and location
    public Bank(String bankName, String bankLocation) {
        this.bankName = bankName;
        this.bankLocation = bankLocation;
    }

    // Method to authorize an account, simulating an authorization process
    public boolean authorize(String accountNumber) {
        System.out.println("Authorizing account: " + accountNumber);
        return true; // Assume authorization is always successful for simplicity
    }

    // Method to manage the transaction
    public void manageTransaction(Transaction transaction) {
        System.out.println("Managing transaction of type: " + transaction.getType());
        System.out.println("Amount: $" + transaction.getAmount());
    }

    // Method to prompt for bank information from the user
    public static Bank promptForBankDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();

        System.out.print("Enter bank location: ");
        String bankLocation = scanner.nextLine();

        return new Bank(bankName, bankLocation);  // Create and return a new Bank object
    }

    // Method to prompt for an account number from the user
    public static String promptForAccountNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        return scanner.nextLine();  // Return the account number entered by the user
    }

    // Method to prompt for transaction details from the user
    public static Transaction promptForTransaction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter transaction type (Deposit/Withdrawal): ");
        String type = scanner.nextLine();

        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Clear the buffer

        // Create and return a new transaction object
        return new Transaction(new java.util.Date(), type, amount, "TXN" + System.currentTimeMillis());
    }

    // Main method for user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for bank details
        Bank bank = Bank.promptForBankDetails();

        // Prompt for account number
        String accountNumber = Bank.promptForAccountNumber();

        // Simulate authorizing the account
        boolean isAuthorized = bank.authorize(accountNumber);
        if (isAuthorized) {
            System.out.println("Account authorized successfully.");
        } else {
            System.out.println("Account authorization failed.");
            return; // Exit the program if authorization fails
        }

        // Prompt for transaction details
        Transaction transaction = Bank.promptForTransaction();

        // Simulate managing the transaction
        bank.manageTransaction(transaction);

        // Optionally, you can add more transactions or further interaction here.
    }
}
