package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction
{
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try
        {
            Class.forName(DB_DRIVER);
            con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            con.setAutoCommit(false);

            ps1=con.prepareStatement("UPDATE account SET balance=balance-500 WHERE ac=101");
            ps1.executeUpdate();
            Integer.parseInt("ASNLNDA");


            ps2=con.prepareStatement("UPDATE account SET balance=balance+500 WHERE ac=102");
            ps2.executeUpdate();

            con.commit();
            con.close();
            System.out.println("Amount is Transfer Successful.!!!");
        }
        catch (Exception e) {
            System.out.println("Transaction Failed!!!");
            try {
                con.rollback();
            }
            catch (SQLException el)
            {
                el.printStackTrace();
            }
        }
    }
}
