package com.tca;

import java.sql.*;

public class ResultSetType
{
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try{
            Class.forName(DB_DRIVER);
            conn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("select * from student");

            System.out.println("********** Forward-Only ****************");
            while(rs.next())
            {
                System.out.println("Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name")+" Per : "+rs.getFloat("per"));
            }

            System.out.println();
            System.out.println("********** Backward-Only ****************");
            while(rs.previous())
            {
                System.out.println("Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name")+" Per : "+rs.getFloat("per"));
            }

            System.out.println();
            System.out.println("********** Random Position ****************");

            rs.absolute(2);
            System.out.println("Second Row - Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name")+" Per : "+rs.getFloat("per"));

            rs.first();
            System.out.println("First Row - Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name")+" Per : "+rs.getFloat("per"));

            rs.last();
            System.out.println("last Row - Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name")+" per"+rs.getFloat("per"));


            rs.absolute(1);
            System.out.println("Before DataBase Changed");
            System.out.println("First Row - Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name")+" Per : "+rs.getFloat("per"));

            System.out.println("Press Any key to continue.....");
            System.in.read();

            rs.refreshRow();

            System.out.println("After DataBase Changed");
            System.out.println("First Row - Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name")+" Per : "+rs.getFloat("per"));

            /* Upadete 4th row and changed is reflected in a database */
            rs.absolute(4);
            rs.updateString("name","PPP");
            rs.updateFloat("per",40);

            rs.updateRow();
            System.out.println("Record Updated for Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name"));

            /*Deleting 3rd row and changed reflect in databased  */
            rs.absolute(3);
            System.out.println("Before Deleting");
            System.out.println("Third Row - Roll NO : "+rs.getInt("rno")+" Name : "+rs.getString("name")+" Per : "+rs.getFloat("per"));

            rs.deleteRow();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}