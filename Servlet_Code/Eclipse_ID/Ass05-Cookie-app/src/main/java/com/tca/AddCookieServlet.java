package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/add")
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie ck1=new Cookie("Aniket","Jumde");
		Cookie ck2=new Cookie("Pradeep","Jadhav");
		
		ck1.setPath("/");
		ck2.setPath("/");
		
		response.addCookie(ck1);
		response.addCookie(ck2);
		
		out.println("Cookies are saved.!!!");
		out.close();
	}

}
