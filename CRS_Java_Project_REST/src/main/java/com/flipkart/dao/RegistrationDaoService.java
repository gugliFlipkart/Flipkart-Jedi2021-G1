package com.flipkart.dao;

import com.flipkart.clientMenu.CRSApplication;
import com.flipkart.constant.SqlQueries;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDaoService implements RegistrationDaoInterface{
    private static Logger logger = Logger.getLogger(CRSApplication.class);
    @Override
    public double calculateFee(String studentId) throws SQLException {
        Connection conn = DBUtils.getConnection();
        PreparedStatement stmt = null;
        double fee = 0;
        try
        {
            stmt = conn.prepareStatement(SqlQueries.CALCULATE_FEES);
            stmt.setString(1, studentId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            fee = rs.getDouble(1);
        }
        catch(SQLException e)
        {
            logger.error(e.getErrorCode());
            logger.info(e.getMessage());
        }
        catch(Exception e)
        {
            logger.info(e.getMessage());
        }
        finally
        {
            stmt.close();
            conn.close();
        }
        //todo @sahil why close connection janb khi nhi kiya hai ye???

        return fee;
    }
}
