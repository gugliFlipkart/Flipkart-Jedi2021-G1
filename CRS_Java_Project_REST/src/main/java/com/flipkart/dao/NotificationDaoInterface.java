package com.flipkart.dao;

import com.flipkart.bean.Notification;

import java.sql.SQLException;

public interface NotificationDaoInterface {
    public void sendNotification(String transactionId, String studentId, String message, double amount) throws ClassNotFoundException, SQLException;
}
