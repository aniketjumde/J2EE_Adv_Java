package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing
{
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try
        {
            Class.forName(DB_DRIVER);
            conn.setAutoCommit(false);
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            stmt=conn.createStatement();

            stmt.addBatch("Insert into employee values (104,'DDD',38.3)");
            stmt.addBatch("Insert into employee values (105,'EEE',78.3)");
            stmt.addBatch("Insert into employee values (106,'FFF',40.3)");

            stmt.executeBatch();

            conn.commit();
            stmt.close();
            conn.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }
    }
}
