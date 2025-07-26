package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/sum")
public class SumServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String num1=request.getParameter("num1");
		String num2=request.getParameter("num2");
		
		if(num1.length()==0 && num2.length()==0)
		{
			out.println("Error-Message : All input is not Recevied.!");
			
		}
		else
		{
			
		}

		
		out.close();
	}

}
