
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servletp1
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servletp1" })
public class Servletp1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(false);
		if (session == null)
			out.println("no session");
		else {
			RequestDispatcher rd = req.getRequestDispatcher("psychology.html");
			rd.forward(req, res);
		}
	}

}
