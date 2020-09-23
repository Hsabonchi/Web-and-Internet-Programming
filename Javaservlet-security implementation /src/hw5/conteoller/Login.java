package hw5.conteoller;

import java.io.IOException;
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

import hw5.model.CandidateReviewsEntry;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/View/Login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		String uname,uPassword;
		boolean is_admin = false;
		boolean is_user = false;

		// System.out.print(username + "<----------->" + password);
		Connection c = null;

		try {
			String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu63";
			String password = "xB99.O*n";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("select * from users;");

			while (rs.next()) {
				uname = rs.getString("name");
				uPassword = rs.getString("password");
				boolean admin = rs.getBoolean("is_admin");
				if ((uname.equals(inputUsername)) && (uPassword.equals(inputPassword))) {
					if (admin) {
						is_admin = true;
						is_user = true;
					}
					else {
						is_user = true;
					}

					request.getSession().setAttribute("userName", uname);
					request.getSession().setAttribute("is_admin", is_admin);
				}
			}
			if (!is_user) {
				response.sendRedirect("Login");
				return;
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
//        System.out.print(is_admin);
		//request.setAttribute("is_admin", is_admin);
		//request.getRequestDispatcher("CandidateReviews").forward(request, response);
		response.sendRedirect("CandidateReviews");
	}

}
