package Final.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

import Final.model.Expense;

@WebServlet("/Month")
public class Month extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Month() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String monthString = request.getParameter("month");
		List<Expense> eList = new ArrayList<Expense>();
		//int id = 0;
		float total =0;
		Connection c = null;

		try {
			String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu63";
			String password = "xB99.O*n";

			c = DriverManager.getConnection(url, username, password);
			
			Statement stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Expenses where month = '"+monthString+"';");

			while (rs.next()) {
				eList.add(new Expense( rs.getInt("id"), rs.getString("month"), rs.getFloat("amount"), new ArrayList<String>()));
			}
			for (Expense expense : eList) {
				float a = expense.getAmount();
				total += a;
			}
			
			Statement stmt2 = c.createStatement();

			ResultSet rs2 = stmt2.executeQuery("select * from Tags");

			while (rs2.next()) {
				for (Expense expense : eList) {
					if (expense.getId() == rs2.getInt("expense_id")) {
						expense.getTags().add(rs2.getString("name"));
					}
				}
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
		request.setAttribute("total", total);
		request.setAttribute("eList", eList);
		request.getRequestDispatcher("WEB-INF/View/Final.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
