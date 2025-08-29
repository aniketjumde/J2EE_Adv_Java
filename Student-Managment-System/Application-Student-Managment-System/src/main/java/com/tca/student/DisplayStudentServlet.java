package com.tca.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class DisplayStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		final String DB_DRIVER="org.postgresql.Driver";
		final String DB_URL="jdbc:postgresql://localhost/ajdb20";
		final String DB_USER="root";
		final String DB_PASSWORD="root@123";
		
		String query="SELECT * FROM Student Order by rno ";
		try
		{
			Class.forName(DB_DRIVER);
			con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			/*
			
			
			while(rs.next())
			{
				out.println(rs.getInt(1)+"-->"+rs.getString(2)+"--->"+rs.getDouble(3)+"<br/>");
			}
			
			*/
			
			List<Student> L=new ArrayList<>();  // L --> [101..],[102..],[103.]
			
			while(rs.next())
			{
				/*
				int rno = rs.getInt("rno");
				String name = rs.getString("name");
				double per = rs.getDouble("per");
				
				L.add( new Student(rno,name,per) );
				
				*/
				
				L.add(new Student(rs.getInt("rno"),rs.getString("name"),rs.getDouble("per")));
			}
			
			/*
			out.println("Student Information <br/>");
			for(Student s: L)
			{
				out.println(s.getRno()+"-->"+s.getName()+"--->"+s.getPer()+"<br/>");

			}
			
			*/
			
			
			
			
			/* Redirecting the List of Student From View Layer */
			
			request.setAttribute("students", L);
			RequestDispatcher requstDispatcher=request.getRequestDispatcher("DisplayStudent.jsp");
			requstDispatcher.forward(request,response);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	

}
