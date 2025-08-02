package com.tca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Page2
 */
@WebServlet("/Page2")
public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String value[]=request.getParameterValues("lbook"); //values[0:"200", 1:"550"]
		
		int ltotal=0; // 750
		
		if(value!=null)
		{
			for(int i=0;i<value.length;i++)
			{
				ltotal=ltotal+Integer.parseInt(value[i]);
			}
		}
		
		HttpSession hs=request.getSession(true);  //Creating Session
		hs.setAttribute("p1total",ltotal);  //[p1total:ltotal]   It store value in the form of Object
		
		
		//Second Form
		
		out.println("<h1> Page 2 : Servlet & JSP Book </h1>");
		out.println("<form method='GET' action='./Page3' >");
		out.println("<b> Select Books </b><br>");
		out.println("<input type='checkbox' name='sjbook' value='450'> BOOK1  Rs. 450 <br>");
		out.println("<input type='checkbox' name='sjbook' value='300'> BOOK2  Rs. 300 <br>");
		out.println("<input type='checkbox' name='sjbook' value='250'> BOOK3  Rs. 250 <br>");
		out.println("<input type='submit' value='Payment'> ");
		out.println("</form>");
		
		
		out.close();
	}

}
