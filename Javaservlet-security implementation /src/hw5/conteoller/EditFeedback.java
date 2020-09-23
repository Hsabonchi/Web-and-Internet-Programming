package hw5.conteoller;

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

import hw5.model.CandidateReviewsEntry;

@WebServlet("/EditFeedback")
public class EditFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditFeedback() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int feedId = Integer.parseInt(request.getParameter("feedId"));
		int rating;
		String comment;
		Connection c = null;

		try {
			String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu63";
			String password = "xB99.O*n";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("select * from feedback_entries where id = " + feedId + ";");

			while (rs.next()) {
				rating = rs.getInt("rating");
				comment = rs.getString("comment");
				request.setAttribute("feedRating", rating);
				request.setAttribute("feedComment", comment);
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("candidateId", (String)request.getParameter("candidateId"));
		request.setAttribute("feedId", (String)request.getParameter("feedId"));
		request.getRequestDispatcher("WEB-INF/View/EditFeedback.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int feedId = Integer.parseInt(request.getParameter("feedId"));
		int candidateId = Integer.parseInt(request.getParameter("candidateId"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		String comment = request.getParameter("comment");
		
		Connection c = null;
		try {
			String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu63";
			String password = "xB99.O*n";

			c = DriverManager.getConnection(url, username, password);

			String sql = "update feedback_entries set rating = ?, comment = ? where id = ? ;";
			PreparedStatement pstmt = c.prepareStatement(sql);

			pstmt.setInt(1, rating);
			pstmt.setString(2, comment);
			pstmt.setInt(3, feedId);

			pstmt.executeUpdate();

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("CandidateFeedback?index="+ candidateId);
	}

}
