package Com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultSetType
{
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try
        {
            //Step 1: Load the Driver
            Class.forName(DB_DRIVER);

            //Step 2: Established Connection
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            pstmt = conn.prepareStatement("select * from student",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);

            rs = pstmt.executeQuery();

            while (rs.next())
            {
                System.out.println("RNO  :"+rs.getInt("rno"));
                System.out.println("Name :"+rs.getString("name"));
                System.out.println("Percentage :"+rs.getFloat("per"));
                System.out.println("-------------------------------------");
            }
            conn.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
