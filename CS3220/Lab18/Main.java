package Lab18;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void init(ServletConfig config) throws ServletException {
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Files> entries = new ArrayList<Files>();
        Connection c = null;
        try
        {
           
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu01";
            String password = "!mDz8Pt3";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
            
           ResultSet rs = stmt.executeQuery( "select *  from files as f,users as u \n" + 
           		"    where u.id=f.owner_id \n" + 
           		"    and u.name='cysun' \n" + 
           		"    and f.parent_id is null\n" + 
           		"    order by is_folder Desc" );
           
           
            //ResultSet rs = stmt.executeQuery( "select * from files" );


            while( rs.next() )
               
            	entries.add( new Files(
            			rs.getInt( "id" ),
            			rs.getString( "name" ), 
            			rs.getBoolean("is_folder" ), 
            			rs.getInt( "parent_id" ), 
            			rs.getInt( "owner_id" )));
            	//System.out.println(rs.getObject(1));

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

        request.setAttribute( "entries", entries );
   
        request.getRequestDispatcher( "/WEB-INF/view.jsp" )
            .forward( request, response );
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
