package com.flipkart.bean;

public class Notification {

    private String transactionID;
    private String studentId;
    private String message;
    private double amount;

    @Override
    public String toString() {
        return "Notification{" +
                "transactionID='" + transactionID + '\'' +
                ", studentId='" + studentId + '\'' +
                ", message='" + message + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Notification(String transactionID, String studentId, String message, double amount) {
        this.transactionID = transactionID;
        this.studentId = studentId;
        this.message = message;
        this.amount = amount;
    }
}
