package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloJDBC")
public class HelloJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	 protected void doGet( HttpServletRequest request,
		        HttpServletResponse response ) throws ServletException, IOException
		    {
		        PrintWriter out = response.getWriter();
		        out.println( "<!DOCTYPE html>" );
		        out.println( "<html><head><title>Hello JDBC</title></head><body>" );

		        Connection c = null;
		        try
		        {
		            String url = "jdbc:mysql://localhost/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
		            String username = "cs3220stu01";
		            String password = "!mDz8Pt3";

		            c = DriverManager.getConnection( url, username, password );
		            Statement stmt = c.createStatement();
		            ResultSet rs = stmt.executeQuery( "select * from items" );

		            while( rs.next() )
		            {
		                out.println( rs.getString( "name" ) );
		                out.println( rs.getString( "price" ) );
		                out.println( rs.getFloat( "quantity" ) );
		                out.println( "<br>" );
		            }

		            c.close();
		        }
		        catch( SQLException e )
		        {
		            e.printStackTrace();
		        }
		        finally
		        {
		            try
		            {
		                if( c != null ) c.close();
		            }
		            catch( SQLException e )
		            {
		                e.printStackTrace();
		            }
		        }

		        out.print( "</body></html>" );
		    }

	
	
	
	
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
