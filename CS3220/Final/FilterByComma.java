package Expenses;

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


@WebServlet("/FilterByComma")
public class FilterByComma extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String T1 ="";
		
		int id =Integer.parseInt(request.getParameter("id"));
		
		String t=request.getParameter("t");
		
		String[] T = t.split(",");
		
		T[0]= T1; 
		
		double total=0;		
		ResultSet rs;
		
		List<Expenses> entries2 = new ArrayList<Expenses>();
		
		 Connection c = null;
	        try
	        {
	           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
		            String username = "cs3220stu01";
		            String password = "!mDz8Pt3";


	            c = DriverManager.getConnection( url, username, password );
	           
	            String sql= "SELECT * from expenses where SUBSTRING_INDEX(tags, ',', 1) ='"+T1+'";
	            
	           / /PreparedStatement pstmt = c.prepareStatement( sql);
	           // pstmt.setString( 1,  T1 ); 
	           
	             rs= pstmt.executeQuery(sql);
	            
	            System.out.println("Filter2"+sql);
	            
	           	                      
	            while( rs.next() ){
	                entries2.add( new Expenses ( 
	                	rs.getInt( "id" ),
	                    rs.getString( "month" ), rs.getDouble ("amount" ),
	                    rs.getString( "tags" ) ) );
			}

	            
	            
	            
	            
	            
	            
	               
	            // calculate the total sum of Expenses
//	               rs = stmt.executeQuery( " SELECT SUM(amount) as sum FROM expenses where month='"+M+"'");
//	               while( rs.next() ){
//	            	   
//	            	   total=rs.getDouble ("sum");
//	            	   
//	               }
//	            
	            
	            
	          
	            
	         
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
		
		
	        //getServletContext().setAttribute( "total", total );
	        getServletContext().setAttribute( "entries2", entries2 );
	        
	        
            request.getRequestDispatcher( "/WEB-INF/FilterDisp.jsp" ).forward( request, response );
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
