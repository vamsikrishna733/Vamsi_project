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

public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String un=request.getParameter("uname");
		String pw=request.getParameter("upass");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi", "root", "password"); // gets a new connection
		System.out.println("username"+un+"password"+pw);
		PreparedStatement ps = c.prepareStatement("select  * from saran where USERNAME=? and PASSWORD=?");
		
		
		ps.setString(1, un);
		ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{						
			RequestDispatcher rd= request.getRequestDispatcher("sucessful.html");
			rd.forward(request, response);
		}
		else
		{	
			
			out.println("sorry user name or password is invalid");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		}
		}
		
		catch (Exception e) 
		{
			System.out.println("Some thing went wrong.....!" +e);
		
	}
		
		
	}

}
