package hw5.conteoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw5.model.CandidateReviewsEntry;

@WebServlet("/AddCandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCandidate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/View/AddCandidate.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name, spcialties, presentation;
		name = request.getParameter("name");
		spcialties = request.getParameter("specialties");
		presentation = request.getParameter("presentation");

		Connection c = null;
		try {
			String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu63";
			String password = "xB99.O*n";

			c = DriverManager.getConnection(url, username, password);

			String sql = "insert into candidates_entries (rating, name, specialties, presentation) values (?, ?,?,?);";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, -1);
			pstmt.setString(2, name);
			pstmt.setString(3, spcialties);
			pstmt.setString(4, presentation);
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

		response.sendRedirect("CandidateReviews");
	}

}
