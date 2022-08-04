package com.product.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection connection;
       
   	@Override
   	public void init(ServletConfig config) throws ServletException {

   		try {
   			ServletContext context = config.getServletContext();
   			Class.forName("com.mysql.jdbc.Driver");
   			connection = DriverManager.getConnection(context.getInitParameter("dburl"),
   					context.getInitParameter("dbuser"), context.getInitParameter("dbpassword"));
   		} catch (ClassNotFoundException e) {
   			e.printStackTrace();
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}

   	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String id = request.getParameter("id");
		try(PreparedStatement statement = connection.prepareStatement("select * from product where productID=?");){
			statement.setString(1, id);
			ResultSet results = statement.executeQuery();
			statement.getResultSet();
			PrintWriter out = response.getWriter();
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Product ID</th>");
			out.println("<th>Product Name</th>");
			out.println("<th>Cost</th>");
			out.println("</tr>");
			if(results.next())
			{
				out.println("<tr>");
				out.println("<td>" + results.getString(1) + "</td>");
				out.println("<td>" + results.getString(2) + "</td>");
				out.println("<td>" + results.getString(3) + "</td>");
				out.println("</tr>");
			}else {
				out.println("<h4>Check your productID</h4>");
			}
			out.println("</table>");
			out.println("<p><a href=\"product.html\">GO BACK</a></p>");
			
		}catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}