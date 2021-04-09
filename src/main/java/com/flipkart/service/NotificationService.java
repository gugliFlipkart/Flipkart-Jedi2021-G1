package com.flipkart.service;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDao;
import com.flipkart.dao.NotificationDaoInterface;

import java.sql.SQLException;
import java.util.UUID;

public class NotificationService implements NotificationInterface {

    NotificationDaoInterface notificationDaoInterface = new NotificationDao();

    @Override
    public Notification sendNotification(String studentId, String message, double amount) throws ClassNotFoundException, SQLException {
        UUID uuid = UUID.randomUUID();
        String transactionId = uuid.toString();

        notificationDaoInterface.sendNotification(transactionId, studentId, message, amount);


        Notification notification = new Notification(transactionId, studentId, message, amount);
        return notification;
    }

}
