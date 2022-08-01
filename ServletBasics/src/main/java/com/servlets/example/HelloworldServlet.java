package com.servlets.example;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloworldServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h2>Welcome server</h2>");
		pw.println("<h3>This is my server</h3>");
		pw.println("</body>");
		pw.println("</html>");
		
	}

}
