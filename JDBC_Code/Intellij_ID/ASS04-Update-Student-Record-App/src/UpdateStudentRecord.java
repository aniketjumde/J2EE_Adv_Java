import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateStudentRecord
{
    public static void main(String[] args) {

        Connection con=null;
        PreparedStatement ps=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        final String DB_URL="jdbc:postgresql://localhost:5432/ajdb20";
        final String DB_USER="root";
        final String DB_PASSWORD="root@123";
        final String DB_DRIVER="org.postgresql.Driver";


        try
        {
            Class.forName(DB_DRIVER);
            con= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("Enter the Roll Number to Update Record :");
            int rollNo=Integer.parseInt(br.readLine());
            System.out.println("Enter the Student Name :");
            String studentName=br.readLine();
            System.out.println("Enter the Percentage:");
            Float percentage=Float.parseFloat(br.readLine());

            ps=con.prepareStatement("Update student set name=? , per=? Where rno=? ;");
            ps.setString(1, studentName);
            ps.setFloat(2, percentage);
            ps.setInt(3, rollNo);

            int update=ps.executeUpdate();
            if(update==0)
            {
                System.out.println("Unable to update record");
            }
            else
            {
                System.out.println("Record Updated Successfully");
            }

            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
