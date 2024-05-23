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


public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public register() {
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
		
		String a=request.getParameter("user");
		String b=request.getParameter("email");
		String c=request.getParameter("pwd");
		
	
		
		
		try
		{     
			PreparedStatement ps; 
			String query="insert into form (username,email,password)values(?,?,?)";        
        
         ps=myconnection.getConnection().prepareStatement(query);
         ps.setString(1,a);
         ps.setString(2,b);
         ps.setString(3,c);
         
         
            if(ps.executeUpdate()>0)
	        {
	          RequestDispatcher rd=request.getRequestDispatcher("register.html?msg");
	         
	          out.print("<h1 style=text-align:center;color:darkgreen;>REGISTER SUCCESSFULLY</h1>");
	        }
	        else
	        {
	          
	          RequestDispatcher rd=request.getRequestDispatcher("register.html?msg");
	          rd.include(request,response);
	          out.print("<p style=text-align:center;color:red;>STUDENT IS NOT REGISTERED</p>");
	        }	 
	        
			}
	        catch(Exception ex)
			{
				System.out.println(ex);
			}
		
	}
	

	}