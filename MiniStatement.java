package com.mycompany.atm;

import java.util.ArrayList;
import java.util.List;

public class MiniStatement {
    private List<Transaction> transactions;

    public MiniStatement() {
        this.transactions = new ArrayList<>();
    }

    // This method should accept a Transaction object
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printStatement() {
        System.out.println("\nMini Statement:");
        if (transactions.isEmpty()) {
            System.out.println("No recent transactions.");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println("Transaction Date: " + transaction.getDate());
                System.out.println("Transaction ID: " + transaction.getTransactionId());
                System.out.println("Type: " + transaction.getType());
                System.out.println("Amount: $" + transaction.getAmount());
                System.out.println("----------------------------");
            }
        }
    }
}
