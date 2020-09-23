package hw5.conteoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw5.model.CandidateReviewsEntry;
import hw5.model.FeedbackEntry;

@WebServlet(urlPatterns = "/CandidateReviews", loadOnStartup = 1)
public class CandidateReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CandidateReviews() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CandidateReviewsEntry> candidatesList = new ArrayList<CandidateReviewsEntry>();
		Connection c = null;
		
        try
        {
            String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu63";
            String password = "xB99.O*n";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery( "select * from candidates_entries;" );
           
            while( rs.next() )
            {
            	candidatesList.add(new CandidateReviewsEntry(rs.getInt( "id" ), rs.getDouble("rating"), rs.getString( "name" ), rs.getString("specialties"), rs.getString("presentation")));
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
        request.setAttribute("candidatesList", candidatesList);
		request.getRequestDispatcher("WEB-INF/View/CandidatesDisplay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
