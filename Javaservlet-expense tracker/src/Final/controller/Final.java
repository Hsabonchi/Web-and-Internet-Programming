package Final.controller;

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

import Final.model.Expense;


@WebServlet("/Final")
public class Final extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Final() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

			ResultSet rs = stmt.executeQuery("select * from Expenses");

			while (rs.next()) {
				eList.add(new Expense(rs.getInt("id"),rs.getString("month"), rs.getFloat("amount"), new ArrayList<String>()));
			}
			for (Expense expense : eList) {
				float a = expense.getAmount();
				total += a;
			}
			
			Statement stmt2 = c.createStatement();

			ResultSet rs2 = stmt2.executeQuery("select * from Tags");

			while (rs2.next()) {
				//eList.add(new Expense(id++, rs2.getString("month"), rs2.getFloat("amount"), new ArrayList<String>()));
//				List<String> tagList = new ArrayList<String>();
//				tagList.add(rs2.getString("tag"));
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
		
		int insertId = 0;
		float amount = Float.parseFloat(request.getParameter("amount"));
		String monthString = request.getParameter("month");
		if (monthString == null || monthString.trim() == "") {
			monthString = "5/2019";
		}
		String tagsString = request.getParameter("tags");
		
		Connection c = null;

		try {
			String url = "jdbc:mysql://localhost/cs3220stu63?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu63";
			String password = "xB99.O*n";

			c = DriverManager.getConnection(url, username, password);

			String sql = "insert into Expenses (month, amount) values(?, ?);";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, monthString);
			pstm.setFloat(2, amount);
			pstm.executeUpdate();
			
			Statement stmt3 = c.createStatement();
			ResultSet rs3 = stmt3.executeQuery("SELECT LAST_INSERT_ID() as insert_id;");
			
			while (rs3.next()) {
				insertId = rs3.getInt("insert_id");
			}
			
			
			String [] tags = tagsString.split(",");
			//
			for(String n:tags) {
				//System.out.println(a);
				String sql2 = "insert into Tags (name, expense_id) values(?, ?);";
				PreparedStatement pstm2 = c.prepareStatement(sql2);
				pstm2.setString(1, n);
				pstm2.setInt(2, insertId);
				pstm2.executeUpdate();
			}
			//
			
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
		
		
		response.sendRedirect("Final");
	}

}
