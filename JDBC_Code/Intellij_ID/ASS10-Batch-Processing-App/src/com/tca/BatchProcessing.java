package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

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
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            stmt=conn.createStatement();
            conn.setAutoCommit(false);

            stmt.addBatch("Insert into student values (108,'DDD',38.3)");
            stmt.addBatch("Insert into student values (109,'EEE',78.3)");
            stmt.addBatch("Insert into student values (110,'FFF',40.3)");

            int sval[]=stmt.executeBatch();
            System.out.println("Status : "+Arrays.toString(sval));

            conn.commit();
            stmt.close();
            conn.close();
            System.out.println("Operation is Successfully...!");
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
