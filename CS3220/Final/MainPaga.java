package Expenses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MainPaga")
public class MainPaga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 double total=0;
		ResultSet rs;
		
		// list  of Expenses
		List<Expenses> entries = new ArrayList<Expenses>();
        Connection c = null;
        try
        {
           	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
             rs = stmt.executeQuery( "select * from expenses" );

            while( rs.next() ){
                entries.add( new Expenses ( 
                	rs.getInt( "id" ),
                    rs.getString( "month" ), rs.getDouble ("amount" ),
                    rs.getString( "tags" ) ) );
		}

            
            
            
               
            // calculate the total sum of Expenses
               rs = stmt.executeQuery( " SELECT SUM(amount) as sum FROM expenses;" );
               while( rs.next() ){
            	   
            	   total=rs.getDouble ("sum");
            	   
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
                                                    
        getServletContext().setAttribute( "entries", entries );

        
        
        getServletContext().setAttribute( "total", total );
		
        request.getRequestDispatcher( "/WEB-INF/MainPaga.jsp" ).forward( request, response );
		
		
		
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Adding Expenses
		
		
		
		
		Connection c = null;
        try
        {
          	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";


            String sql = "INSERT INTO `expenses` (`month`, `amount`, `tags`) VALUES (?,? ,? );  ";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, request.getParameter( "m" ) );
            pstmt.setDouble( 2, Double.parseDouble(request.getParameter( "a" )) );
            pstmt.setString( 3, request.getParameter( "t" ) );
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

		
		
		
        response.sendRedirect( "MainPaga" );
		
		
		
		
		
		
		
		
		
		
		
			
		
		
		
	}

}
