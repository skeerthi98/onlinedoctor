
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlets1
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servlets1" })
public class Servlets1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta content='no_cache'>");
		out.println("<style>");
		out.println("body{");
		out.println("background-image: url(\"bg7.jpg\");");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<br><br>");
		HttpSession session = req.getSession(false);
		if (session == null) {
			// res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			// res.setDateHeader("Expires", 0);
			out.println("<h1 style=\"font-color:red;\">Session expired</h1>");
			out.println("want to login again..click on below link..");
			out.println("<br>");
			out.println("<a href=\"login.html\">login</a>");
		}
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);

		String s = session.getId();
		String x = (String) session.getAttribute("value");
		String y = (String) session.getAttribute("name");
		if (s.equals(x)) {
			Date createTime = new Date(session.getCreationTime());
			Date lastAccessTime = new Date(session.getLastAccessedTime());
			ServletContext context = getServletContext();
			Integer count = (Integer) context.getAttribute("c");
			out.println("Thank you for using<h1>online doctor</h1>!!!");
			out.println("<br>");
			out.println("username:" + " " + y + "\n");
			out.println("<br>");
			out.println("login time:" + " " + createTime + "\n");
			out.println("<br>");
			out.println("Last accessed time:" + " " + lastAccessTime + "\n");
			out.println("<br>");
			out.println("visits:" + " " + count + "\n");
			out.println("<br>");
			session.invalidate();

		}
		out.println("</body>");
		out.println("</html>");
	}

}
