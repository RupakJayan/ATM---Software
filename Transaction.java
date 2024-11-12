package com.mycompany.atm;

import java.util.Date;

public class Transaction {
    private final Date date;
    private final String type; // e.g., "Deposit" or "Withdrawal"
    private final double amount;
    private final String transactionId;

    public Transaction(Date date, String type, double amount, String transactionId) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.transactionId = transactionId;
    }

    public void printReceipt() {
        System.out.println("Transaction Receipt:");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Date: " + date);
        System.out.println("Type: " + type);
        System.out.println("Amount: $" + amount);
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
