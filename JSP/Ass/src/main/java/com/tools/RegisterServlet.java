package com.tools;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone_no");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("con_password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            if (!password.equals(cpassword)) {
                out.println("<h3>Passwords do not match. <a href='register.jsp'>Try Again</a></h3>");
                return;
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/smart_agri", "root", "sujit");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name, email, phone_no, password) VALUES (?, ?, ?, ?)");
            
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, password);  // TODO: Hash this before saving
            
            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<h3>Registration Successful. <a href='login.jsp'>Login Here</a></h3>");
            } else {
                out.println("<h3>Registration Failed. Try again.</h3>");
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
