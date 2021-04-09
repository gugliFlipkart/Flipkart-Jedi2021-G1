package com.flipkart.service;

import com.flipkart.bean.Notification;
import com.flipkart.clientMenu.CRSApplication;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.dao.PaymentDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PaymentService implements PaymentInterface {

    private static Logger logger = Logger.getLogger(PaymentService.class);
    RegistrationInterface registrationInterface = new RegistrationSevice();
    NotificationInterface notificationInterface = new NotificationService();
    PaymentDao paymentDao = new PaymentDao();
    Scanner sc = new Scanner(System.in);

    @Override
    public void make_payment(String studentId) {
        double fee = 0.0;
        try {
            fee = registrationInterface.calculateFee(studentId);
        } catch (SQLException e) {

            logger.info(e.getMessage());
        }

        if (fee == 0.0) {
            logger.info("You have not  registered for any courses yet");
        } else {

            logger.info("Your total fee  = " + fee);
            logger.info("continue Fee Payment");

            logger.info("Select Mode of Payment:");

            int index = 1;
            for (ModeOfPayment mode : ModeOfPayment.values()) {
                logger.info(index + " " + mode);
                index = index + 1;
            }

            ModeOfPayment mode = ModeOfPayment.getModeofPayment(sc.nextInt());

            // Make Payment
            try {
                paymentDao.make_payment(studentId, mode, fee);
                logger.info("<<---- Payment Done ---->> " );
            } catch (Exception e) {
                logger.info(e.getMessage());
            }

            // Send Notification
            try {
                Notification notification = notificationInterface.sendNotification(studentId, "Successful", fee);
                logger.info("Payment Notification ---->> " + notification.toString() );
            } catch (Exception e) {

                logger.info(e.getMessage());
            }


        }

    }

}


