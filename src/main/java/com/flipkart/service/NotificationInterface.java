package com.flipkart.service;

import com.flipkart.bean.Notification;
import com.flipkart.constant.ModeOfPayment;

import java.sql.SQLException;
import java.util.UUID;

public interface NotificationInterface {

    public Notification sendNotification(String studentId, String message, double amount) throws ClassNotFoundException, SQLException;

}
