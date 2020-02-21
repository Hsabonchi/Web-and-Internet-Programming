package Lab18;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteF")
public class DeleteF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id"+" "+request.getParameter("id"));
		
		
		Connection c = null;
		
		  try
	        {
	           
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	          
	            
//	            String sql = "DELETE FROM files  WHERE id='" id "';
	            
	            PreparedStatement pstmt = c.prepareStatement( "DELETE FROM files  WHERE id=?" );
	            pstmt.setInt(1,Integer.parseInt(request.getParameter("id")));
	            //pstmt.setString( 1, request.getParameter("id"));
	            pstmt.executeUpdate();
	           // .c.executeUpdate( sql);

	            

	            
	            
	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
		
		
		
			response.sendRedirect("Main");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
