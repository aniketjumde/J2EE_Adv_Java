package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NRecords
{
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String DB_URL = "jdbc:postgresql://localhost/ajdb20";
        final String DB_USER = "root";
        final String DB_PASSWORD = "root@123";
        final String DB_DRIVER = "org.postgresql.Driver";

        try
        {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            pstmt=conn.prepareStatement("insert into student values (?,?,?)");

            while (true)
            {
                System.out.print("Enter Student Roll No : ");
                int rollNo = Integer.parseInt(br.readLine());
                System.out.print("Enter Student Name : ");
                String name = br.readLine();
                System.out.print("Enter Student Percentage : ");
                float percent = Float.parseFloat(br.readLine());

                pstmt.setInt(1, rollNo);
                pstmt.setString(2, name);
                pstmt.setFloat(3, percent);

                pstmt.addBatch(); //Addding SQL into the batch

                System.out.println("Do You Want To Add New Record");
                String option=br.readLine();
                if (option.equalsIgnoreCase("Yes"))
                {
                   continue;
                }
                else
                {
                    break;
                }
            }
            pstmt.executeBatch();
            System.out.println("Records Saved Successfully");
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
