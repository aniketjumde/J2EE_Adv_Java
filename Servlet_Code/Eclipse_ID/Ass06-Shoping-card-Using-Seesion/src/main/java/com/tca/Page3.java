package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Page3
 */
@WebServlet("/Page3")
public class Page3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String value[]=request.getParameterValues("sjbook"); //values[0:"200", 1:"550"]
		
		int sjtotal=0; // 750
		
		if(value!=null)
		{
			for(int i=0;i<value.length;i++)
			{
				sjtotal=sjtotal+Integer.parseInt(value[i]);
			}
		}
		
		HttpSession hs=request.getSession(false);
		int ltotal=Integer.parseInt(hs.getAttribute("p1total").toString());
		
		
		/*
		Object o = hs.getAttribute("p1total");
		String s = o.toString();
		int ltotal = Integer.parseInt(s);
		*/
		
		// Bill Logic
		
		
		int bil=ltotal + sjtotal;
		
		out.println("<h2>Bill</h2>");
		out.println("Page   1   :  "+ltotal+"<br>");	
		out.println("Page   2   :  "+sjtotal+"<br>");		
		out.println("Total Bill :  "+bil+"<br>");		
		
		
		hs.invalidate(); // destroying session
		
		
		out.close();
	}
	
	
}
