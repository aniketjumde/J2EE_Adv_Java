package com.tca;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallabelStatementDemo
{
    public static void main(String[] args) {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try {
            Class.forName(DB_DRIVER);
            con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            cs=con.prepareCall("select msg()");
            //cs=con.prepareCall("select add(5, 8)");
            //cs=con.prepareCall("select addInfo(103,'CCC','99.2')");
            rs=cs.executeQuery();
            while (rs.next()) {
                System.out.println("OUTPUT :"+rs.getString(1));
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
