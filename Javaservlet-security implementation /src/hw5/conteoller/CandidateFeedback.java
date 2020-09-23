package hw5.conteoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

import hw5.model.CandidateReviewsEntry;
import hw5.model.FeedbackEntry;

@WebServlet("/CandidateFeedback")
public class CandidateFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CandidateFeedback() {
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
				entry.setmID(rs.getInt("id"));
				entry.setmRating(rs.getDouble("rating"));
				entry.setmName(rs.getString("name"));
				entry.setmSpecialties(rs.getString("specialties"));
				entry.setmPresentation(rs.getString("presentation"));
			}

			Statement stmtn = c.createStatement();

			ResultSet rsn = stmtn.executeQuery(
					"select fe.* from feedback_entries fe, candidates_entries c where  c.id = fe.candidate_id and c. id = "
							+ index + ";");

			List<FeedbackEntry> feedback = new ArrayList<FeedbackEntry>();

			while (rsn.next()) {
				feedback.add(new FeedbackEntry(rsn.getInt("rating"), rsn.getString("name"), rsn.getString("comment"),
						rsn.getDate("date"), rsn.getString("user_name"), rsn.getInt("id")));
			}

			if (feedback.size() > 0) {
				double rates = 0;
				for (FeedbackEntry feedbackEntry : feedback) {
					rates += feedbackEntry.getRating();
				}
				rates = rates / feedback.size();
				entry.setmRating(rates);
				request.setAttribute("feedbackEntries", feedback);
			}

			// start
			String uName = (String) request.getSession().getAttribute("userName");
			Statement stmtn2 = c.createStatement();
			ResultSet rsn2 = stmtn2.executeQuery("select count(id) from feedback_entries where user_name='" + uName
					+ "' and candidate_id=" + index + " group by candidate_id;");
			while (rsn2.next()) {
				int numFeedback = rsn2.getInt("count(id)");
				// request.getSession().setAttribute("numFeedback", numFeedback);
				request.setAttribute("numFeedback", numFeedback);
				//System.out.print(numFeedback);
			}

			// end

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
		request.setAttribute("index", index);
		request.getRequestDispatcher("WEB-INF/View/CandidateFeedback.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("rating") != null && request.getParameter("comment") != null
				&& request.getParameter("comment").trim() != "") {

			int rate = Integer.parseInt(request.getParameter("rating"));
			// String name = request.getParameter("name");
			String name = (String) request.getSession().getAttribute("userName");
			String comment = request.getParameter("comment");
			int index = Integer.parseInt(request.getParameter("index"));
			CandidateReviewsEntry entry = new CandidateReviewsEntry();
			List<FeedbackEntry> feedback = entry.getfEntries();

			Connection c = null;
			try {
				String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
				String username = "cs3220stu63";
				String password = "xB99.O*n";

				c = DriverManager.getConnection(url, username, password);

				String sql = "insert into feedback_entries (rating, name , comment, date,user_name, candidate_id) values (?,?,?,now(),?,?);";
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setDouble(1, rate);
				pstmt.setString(2, name);
				pstmt.setString(3, comment);
				String uName = (String) request.getSession().getAttribute("userName");
				pstmt.setString(4, uName);
				pstmt.setInt(5, index);
				pstmt.executeUpdate();

				Statement stmtn = c.createStatement();

				ResultSet rsn = stmtn.executeQuery("select * from candidates_entries where id = " + index + ";");

				while (rsn.next()) {
					entry.setmID(rsn.getInt("id"));
					entry.setmRating(rsn.getDouble("rating"));
					entry.setmName(rsn.getString("name"));
					entry.setmSpecialties(rsn.getString("specialties"));
					entry.setmPresentation(rsn.getString("presentation"));
				}

				Statement stmts = c.createStatement();

				ResultSet rss = stmts.executeQuery(
						"select fe.* from feedback_entries fe, candidates_entries c where  c.id = fe.candidate_id and c. id = "
								+ index + ";");

				while (rss.next()) {
					feedback.add(new FeedbackEntry(rss.getInt("rating"), rss.getString("name"),
							rss.getString("comment"), rss.getDate("date"), rss.getString("user_name"), rss.getInt("id")));
				}
				double rates = 0;
				if (feedback.size() > 0) {

					for (FeedbackEntry feedbackEntry : feedback) {
						rates += feedbackEntry.getRating();
					}
					rates = rates / feedback.size();
					entry.setmRating(rates);
				}

				Statement stmt2 = c.createStatement();
				stmt2.executeUpdate("update candidates_entries set rating = " + rates + " where id = " + index + ";");

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
			request.setAttribute("feedbackEntries", feedback);
			request.setAttribute("index", index);
			// request.getRequestDispatcher("WEB-INF/View/CandidateFeedback.jsp").forward(request,
			// response);
			response.sendRedirect("CandidateFeedback?index=" + request.getParameter("index"));
		} else {
			response.sendRedirect("CandidateFeedback?index=" + request.getParameter("index"));
		}

	}

}
