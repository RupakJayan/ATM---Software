package com.mycompany.atm;

import java.util.Scanner;

public class ATM {
    private final int pin;
    private final String location;
    private final String bankName;
    private double balance;

    public ATM(int pin, double initialBalance) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ATM Location: ");
        this.location = scanner.nextLine();

        System.out.print("Enter Bank Name: ");
        this.bankName = scanner.nextLine();

        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }

    public void selectLanguage(String language) {
        System.out.println("Language selected: " + language);
    }

    public void displayOptions() {
        System.out.println("Options: Withdraw, Deposit, Check Balance, Mini Statement");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Please collect your cash: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount entered.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Amount deposited: $" + amount);
        } else {
            System.out.println("Invalid amount entered.");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void miniStatement() {
        // Placeholder for mini-statement. In a real ATM, this would fetch transaction history.
        System.out.println("Mini statement: No recent transactions.");
    }
    
    public String getLocation() {
        return location;
    }

    public String getBankName() {
        return bankName;
    }
}
