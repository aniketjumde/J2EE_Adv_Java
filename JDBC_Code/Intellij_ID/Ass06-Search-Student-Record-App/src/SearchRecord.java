import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchRecord
{
    public static void main(String[] args)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";

        try
        {
            Class.forName(DB_DRIVER);
            con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            System.out.print("Enter the roll number to search :");
            int roll=Integer.parseInt(br.readLine());

            ps=con.prepareStatement("select * from student where rno=?");
            ps.setInt(1,roll);
            rs=ps.executeQuery();
            if(rs.next())
            {
                System.out.println("Record is Found");
                System.out.println("Roll No :"+rs.getString("rno"));
                System.out.println("Name    :"+rs.getString("name"));
                System.out.println("Per     :"+rs.getString("per"));
            }
            else
            {
                System.out.println("Record is Not Found");
            }
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
