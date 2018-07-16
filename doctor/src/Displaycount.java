
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Displaycount
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Displaycount" })
public class Displaycount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		ServletContext context = getServletContext();
		Integer count = (Integer) context.getAttribute("c");
		out.println("<html>");
		out.println("<meta content='no_cache'>");
		if (count != null) {
			out.println("welcome:count is" + count);
		} else {
			out.println("sorry,count not available");
		}
		out.println("</html>");
	}
}
