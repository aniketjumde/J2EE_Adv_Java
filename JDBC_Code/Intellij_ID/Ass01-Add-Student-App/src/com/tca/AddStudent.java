package com.tca;

import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddStudent
{
    public static void main(String[] args)
    {
        Connection con = null;
        PreparedStatement ps=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try
        {
            //STEP 1: Load  Driver
            Class.forName("org.postgresql.Driver");
            //Step 2: Forming a connection using URL,name,password
            con= DriverManager.getConnection("jdbc:postgresql://localhost/ajdb20","root","root@123");

            //Step 3:Preparing SQL Statment
            System.out.print("Enter Rll Number :");
            int rno=Integer.parseInt(br.readLine());
            System.out.print("Enter Name :");
            String name=br.readLine();
            System.out.print("Enter Percentage :");
            Float per=Float.parseFloat(br.readLine());

            ps=con.prepareStatement("INSERT INTO student VALUES (?,?,?)");
            ps.setInt(1,rno);
            ps.setString(2, name);
            ps.setFloat(3,per);

            //step 4: Execute SQL statment

            int sval=ps.executeUpdate();

            if(sval==0)
            {
                System.out.println("Unable to insert Record");
            }
            else
            {
                System.out.println("Record inserted successfully");
            }

            //step 5: Close Conmection
            con.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
