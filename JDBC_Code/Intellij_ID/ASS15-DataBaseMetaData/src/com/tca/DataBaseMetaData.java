package com.tca;

import java.sql.*;

public class DataBaseMetaData
{
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        DatabaseMetaData metaData = null;

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try
        {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            metaData=conn.getMetaData();
            System.out.println(metaData.getDatabaseProductName());
            System.out.println(metaData.getDatabaseProductVersion());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getDriverVersion());

            rs=metaData.getTables(null,null,null,new String[] {"TABLE"});

            System.out.println("TABLES NAME :");

            while (rs.next())
            {
                System.out.println(rs.getString("TABLE_NAME"));
            }



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
