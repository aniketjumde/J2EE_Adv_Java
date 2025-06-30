package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayRecord
{
    public static void main(String[] args)
    {
        Connection con=null;
        PreparedStatement ps=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ResultSet rs=null;

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try
        {
            Class.forName(DB_DRIVER);
            con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps=con.prepareStatement("select * from student order by rno");

            rs=ps.executeQuery();
            while(rs.next())
            {
            /*
                System.out.println("Roll Number : " + rs.getInt(1));
                System.out.println("Name        : " + rs.getString(2));
                System.out.println("Percentage  : " + rs.getDouble(3));
			*/
                System.out.println("Roll Number : " + rs.getInt("rno"));
                System.out.println("Name        : " + rs.getString("name"));
                System.out.println("Percentage  : " + rs.getDouble("per"));

                System.out.println("------------------------------------------");
            }
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
