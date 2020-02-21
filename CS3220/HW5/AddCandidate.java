package HW5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/AddCandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	request.getRequestDispatcher("/WEB-INF/addCandidate.jsp").forward(request, response);

		
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter( "name" );
		String spec=request.getParameter( "specialties" );
		String pres=request.getParameter( "presentation" );
		
		
		if(name.trim().length()==0||spec.trim().length()==0||pres.trim().length()==0) {
			
			response.sendRedirect( "AddCandidate" );
		   return;
			
		}
		
		
		System.out.println(" candidateName "+name);
		System.out.println(" Specia "+spec);
		System.out.println(" Present "+pres);
		
		
		
		
		
		   Connection c = null;
	        try
	        {
	        	   
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            
	           
             String sql = "insert into  Candidates  (name,specialties,presentation) values(?,?,?) ";
	            
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            
	           // ResultSet rs = stmt.executeQuery( sql );
	           pstmt.setString( 1, request.getParameter("name"));
	           pstmt.setString( 2, request.getParameter("specialties"));
	           pstmt.setString( 3, request.getParameter("presentation"));
	           // must be an Integer
	           //pstmt.setInt( 4,  (int) getServletContext().getAttribute( "id" ));
	           
	           pstmt.executeUpdate();
	            
	         

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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
   // get the refrence to ArrayList from Application Scope	
//  ArrayList <CandidateRating> candidates =(ArrayList <CandidateRating>) getServletContext().getAttribute("candidates");
//		
//		
//	    //
//        candidates.add(new CandidateRating(name,spec,pres));
        
        // request to Controller serverlet
		response.sendRedirect( "CandidadatesServ" );	
		
	}

}
