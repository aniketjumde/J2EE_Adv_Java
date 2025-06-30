package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudent
{
    public static void main(String[] args)
    {
        Connection con=null;
        PreparedStatement ps=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajdb20", "root", "root");

            System.out.print("Enter Roll NO:");
            int rollno = Integer.parseInt(br.readLine());

            System.out.print("Enter your name");
            String name = br.readLine();

            System.out.print("Enter your Per");
            Float per = Float.parseFloat(br.readLine());

            ps = con.prepareStatement("Insert Into student Values(?,?,?)");
            ps.setInt(1, rollno);
            ps.setString(2, name);
            ps.setFloat(3, per);

            int sval = ps.executeUpdate();

            if (sval == 0)
            {
                System.out.println("Unable to insert Record");
            }
            else
            {
                System.out.println("Record Inserted Successfully.!!!");
            }

            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
