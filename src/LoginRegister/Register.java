package LoginRegister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String q=request.getParameter("id");  
		String w=request.getParameter("name");  
		String e=request.getParameter("mobile");  
		String r=request.getParameter("username");  
		String t=request.getParameter("password");  

		          
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/vamsi", "root", "password");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into saran values(?,?,?,?,?)");  
		  
		ps.setString(1,q);  
		ps.setString(2,w);  
		ps.setString(3,e);  
		ps.setString(4,r);  
		ps.setString(5,t);  

		int i=ps.executeUpdate();  
		if(i>0)  
		
		response.sendRedirect("index.html");
		out.print("You are successfully registered...");        
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  

		
		
	}
}
