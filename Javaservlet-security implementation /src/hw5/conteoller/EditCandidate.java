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

@WebServlet("/EditCandidate")
public class EditCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCandidate() {
		super();

	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int index = Integer.parseInt(request.getParameter("index"));
		CandidateReviewsEntry entry = new CandidateReviewsEntry();

		Connection c = null;

		try {
			String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu63";
			String password = "xB99.O*n";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("select * from candidates_entries where id = " + index + ";");

			while (rs.next()) {
				entry = new CandidateReviewsEntry(rs.getInt("id"), rs.getString("name"), rs.getString("specialties"),
						rs.getString("presentation"));
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

		request.setAttribute("candidateEntry", entry);

		request.getRequestDispatcher("WEB-INF/View/EditCandidate.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name, spcialties, presentation;
		name = request.getParameter("name");
		spcialties = request.getParameter("specialties");
		presentation = request.getParameter("presentation");
		int index = Integer.parseInt(request.getParameter("id"));

		Connection c = null;
		try {
			String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu63";
			String password = "xB99.O*n";

			c = DriverManager.getConnection(url, username, password);

			String sql = "update candidates_entries set name = ?, specialties = ?, presentation = ? where id = ? ;";
			PreparedStatement pstmt = c.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, spcialties);
			pstmt.setString(3, presentation);
			pstmt.setInt(4, index);

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
