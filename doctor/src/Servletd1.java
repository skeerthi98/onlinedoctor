
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletd1
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servletd1" })
public class Servletd1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String x[] = req.getParameterValues("d");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "keerthi");
			if (con == null)
				out.println("no connection");
			out.println("<html>");
			out.println("<head>");
			out.println("<style>");
			out.println("body{");
			out.println("background-image: url(\"bg7.jpg\");");
			out.println("}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>possible diseases</h1>");
			out.println("<br><br>");
			out.println("<ul style=\"list-style-type:none\">");
			String y = null;
			if (x.length == 1) {
				y = "select * from  " + x[0];

			} else if (x.length == 2) {
				y = "select * from " + x[0] + "natural join " + x[1];

			}
			PreparedStatement statement = con.prepareStatement(y);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String y1 = result.getString(1);
				out.println("<li><a href=\"http://localhost:8083/doctor/" + y1 + "\">" + y1 + "</a></li>");

			}
			con.close();
			out.println("</ul>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
