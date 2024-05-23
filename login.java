package project;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String n=request.getParameter("user");
		String p=request.getParameter("pwd");
		
		try
		{     
			PreparedStatement ps;
        String query="SELECT * FROM form where username=? and password=?";	        
        
         ps=myconnection.getConnection().prepareStatement(query);
         ps.setString(1,n);
         ps.setString(2,p);
          
        ResultSet rs=ps.executeQuery();
					
	        if(rs.next()) 
	        {
	          RequestDispatcher rd=request.getRequestDispatcher("login.html/msg");
	          rd.include(request, response);
	          out.print("<p style=text-align:center;color:red;>LOGGED SUCCESSFULLY</P>");
	        }
	        else
	        {
	          
	          RequestDispatcher rd=request.getRequestDispatcher("login.html");
	          rd.include(request,response);
	          out.print("<p style=text-align:center;color:red;>username or password is incorrect</p>");
	        }	 
	        
			}
	        catch(Exception ex)
			{
				System.out.println(ex);
			}
		
	}
	

	}
