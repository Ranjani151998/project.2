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


public class orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public orders() {
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
		
		String a=request.getParameter("user");
		String b=request.getParameter("email");
		String c=request.getParameter("ph");
		String d=request.getParameter("pr");
		String e=request.getParameter("add");
		String f=request.getParameter("pay");
		
	
		
		
		try
		{     
			PreparedStatement ps; 
			String query="insert into orders (username,email,phonenumber,product,address,payment)values(?,?,?,?,?,?)";        
        
         ps=myconnection.getConnection().prepareStatement(query);
         ps.setString(1,a);
         ps.setString(2,b);
         ps.setString(3,c);
         ps.setString(4,d);
         ps.setString(5,e);
         ps.setString(6,f);
         
         
            if(ps.executeUpdate()>0)
	        {
	          RequestDispatcher rd=request.getRequestDispatcher("orders.html?msg");
	          rd.include(request,response);
	          out.print("<h1 style=text-align:center;color:darkgreen;>ORDER SUCESSFUL</h1>");
	        }
	        else
	        {
	          
	          RequestDispatcher rd=request.getRequestDispatcher("orders.html?msg");
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