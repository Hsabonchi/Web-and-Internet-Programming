package HW5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mainLogin")
public class mainLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	
	protected  Users getEntryName(String name) {
		
		
		@SuppressWarnings("unchecked")
		ArrayList <Users> candidates =((ArrayList <Users>) getServletContext().getAttribute("users"));
			
			  for (Users entry : candidates) {
				  
				  if (entry.getName().equals(name))
			 
			               return entry;
			  }
			
			  return null;
		}
	
	
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

				String passwd=request.getParameter("passwd");
				String name=request.getParameter("name");
				
				Users entry=getEntryName(request.getParameter("name"));
				
				String username =entry.getName();
				
				String pass =entry.getName();
				
				int admin =entry.isIs_admin();
				
				
					// save is admin
				
				
				ServletContext context = this.getServletContext();
		        context.setAttribute( "admin", admin );
		        request.getSession().setAttribute("username",name);
				
					
				 request.getRequestDispatcher( "/WEB-INF/UserPage.jsp" )
		            .forward( request, response );
		
	}
		
	}







//String username="cysun";
//String password="abcd";
//
//String username1="john";
//String password1="abcd";
//
//
//System.out.print("Hi i'm in the post");
//
//String name=request.getParameter("name");
//
//String passwd=request.getParameter("passwd");


//if(name== null||passwd==null||name.trim().length()==0||passwd.trim().length()==0){
//	
//	//you need to add return statment to terminate the program
//	 return;
//	 }
//

//String passwd=request.getParameter("passwd");
//String name=request.getParameter("name");
//Users entry=getEntryName(request.getParameter("name"));
//
//String username =entry.getName();
//String pass =entry.getName();
//int admin =entry.isIs_admin();
//
//
//if (admin==1 ) {
//	 
//	 //out.println("	<h1> correct </h1>");
//	 request.getSession().setAttribute("username",name);
//	 
//	 System.out.print("Hi i'm in the post2");
//	 
//	 request.getRequestDispatcher( "/WEB-INF/Admindisplay.jsp" )
//        .forward( request, response );
//	 
//	// response.sendRedirect("mainLogin");
//
// }
//
//
//
//
//else{
//	 
//	 //out.println("	<h1> correct </h1>");
//	 request.getSession().setAttribute("username",name);
//	 
//	 //System.out.print("Hi i'm in the post2");
//	 
//	 request.getRequestDispatcher( "/WEB-INF/UserPage.jsp" )
//        .forward( request, response );
//	 
//	// response.sendRedirect("mainLogin");
//	 
//	
//	 
//	 
//	 
// }
//
//
//








