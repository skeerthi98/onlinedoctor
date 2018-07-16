
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servletd
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servletd" })
public class Servletd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>\n" + "<frameset rows=\"20,80\" border=0 >");
		out.println("<frame src=\"http://localhost:8083/doctor/header1.html\">\n"
				+ "<frame name=\"center\" src=\"http://localhost:8083/doctor/Servletd1\" scrolling=\"no\">\n"
				+ "</frameset>\n" + "</html>");

		HttpSession session = req.getSession(false);
		if (session == null)
			out.println("no session");
	}

}
