
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servletr1
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servletr1" })
public class Servletr1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String x = req.getParameter("UNAME"), y = req.getParameter("PWD");
		try {
			int c = 0, count;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "keerthi");
			Statement stmt = con.createStatement();
			ResultSet rs2 = stmt.executeQuery("select count(*) from login");
			while (rs2.next()) {
				count = rs2.getInt(1);
				ResultSet rs1 = stmt.executeQuery("select * from login");
				while (rs1.next()) {
					if (rs1.getString(1).equals(x) && rs1.getString(2).equals(y)) {
						con.close();
						HttpSession session = req.getSession();
						String d = session.getId();
						session.setAttribute("name", x);
						session.setAttribute("value", d);
						session.setMaxInactiveInterval(30 * 60);
						// RequestDispatcher rd=req.getRequestDispatcher("main.html");
						// rd.forward(req,res);
						res.sendRedirect("Servletm");
						break;
					} else if (rs1.getString(1).equals(x) && !y.equals(rs1.getString(2))) {
						RequestDispatcher rd = req.getRequestDispatcher("login.html");
						rd.include(req, res);
						out.println("<p style='color:red;'>sry wrong username or password </p>");
						break;
					} else
						c++;
				}
				if (c == count) {
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, res);
					out.println("<p style='color:red;'>You have not registered!!! Please signup...</p>");
				}
			}
			con.close();
		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

}
