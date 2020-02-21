package Lab18;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/addFiles")
public class addFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher( "/WEB-INF/AddFolder.jsp" ).forward( request, response );
		int  id=Integer.parseInt(request.getParameter("id")) ;
		System.out.println(id);
		getServletContext().setAttribute( "id",id );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int id =(Integer) getServletContext().getAttribute("id");
		System.out.println("POst"+id);
		
	    Connection c = null;
		
		
		  try
	        {
	           
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";
	            
	            PreparedStatement pstmt;
	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            //int id =Integer.parseInt(request.getParameter("id"));  
	            
	           
	        	
	            
	            
	        	
	        	if(id >0){
	    			
	    			//System.out.println("id is "+request.getParameter("id"));
	    		    pstmt = c.prepareStatement(  "insert into files  (name,is_folder,parent_id,owner_id) values (?,?,?,?)" );
	    		    
		         	 pstmt.setString( 1, request.getParameter("namef"));
		         	pstmt.setInt( 2, id);
		         	 pstmt.setInt( 3, id);
		         	 pstmt.setInt( 4, id);
		         	 pstmt.executeUpdate();
	    		}
	        	
	        	
	        	
	        	else{
	    			
	    			//System.out.println("id is "+request.getParameter("id"));
	    		    pstmt = c.prepareStatement(  "insert into files  (name,is_folder,parent_id,owner_id) values (?,1,null,1)" );
	    		    
		         	 pstmt.setString( 1, request.getParameter("namef"));
		         	 pstmt.executeUpdate();
	    		} 
	        	
	           
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

}
