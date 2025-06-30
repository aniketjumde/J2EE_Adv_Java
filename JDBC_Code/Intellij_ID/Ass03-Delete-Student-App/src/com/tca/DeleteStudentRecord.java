package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteStudentRecord {

    public static void main(String[] args) {

        Connection con=null;
        PreparedStatement ps=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASS="root@123";
        final String DB_DRIVER="org.postgresql.Driver";
        try
        {
            Class.forName(DB_DRIVER);
            con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            System.out.print("Enter the Roll NO to Delete Record :");
            int roll=Integer.parseInt(br.readLine());

            ps=con.prepareStatement("delete from student where rno=?");
            ps.setInt(1,roll);
            int res=ps.executeUpdate();
            if(res==0)
            {
                System.out.println("Unable to delete record");
            }
            else
            {
                System.out.println("Successfully deleted record");
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
