package com.tca;
import java.sql.Connection;
import java.sql.*;

public class RSMdata
{
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try
        {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select * from student");
            rsmd=rs.getMetaData();

            int n=rsmd.getColumnCount();

            System.out.println("Number of columns in table is:"+n);

            for (int i=1;i<=n;i++)
            {
                System.out.print("Column Name : "+rsmd.getColumnName(i)+"\t");
                System.out.println("Column Type : "+rsmd.getColumnType(i));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
