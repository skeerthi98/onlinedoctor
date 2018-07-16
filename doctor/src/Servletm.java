
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
 * Servlet implementation class Servletm
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servletm" })
public class Servletm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		/*
		 * out.println("<html>\n"+"<frameset rows=\"18,80,5\" border=0 >");
		 * out.println("<frame src=\"http://localhost:8080/project/header1.html\">\n"
		 * +"<frameset cols=\"20,40,25\" border=1>\n"+ "<frame src=\"\">\n"
		 * +"<frame name=\"center\" src=\"choose_sym1.html\" scrolling=\"no\">\n"+
		 * "<frame src=\"\">\n"+"</frameset></frameset>\n"+"<html>");
		 */
		HttpSession session = req.getSession(false);
		if (session == null)
			out.println("no session");
		else {
			RequestDispatcher rd = req.getRequestDispatcher("choose_sym1.html");
			rd.forward(req, res);
		}
	}

}
