
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletf
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servletf" })
public class Servletf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body{");
		out.println("background-image: url(\"bg7.jpg\");");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<br><br>");
		String x = req.getParameter("msg");
		if (x.equals("t")) {

			out.println("thank you opting messaging service...!!");
			out.println("<br>");
			out.println("we will be in touch with you through email");
			out.println("<br>");
			out.println("<h1>FOR DOCTOR APPOINTMENT</h1>");
			out.println("<br>");
			out.println("<b>online doctor:</b>");
			out.println("<br>");
			out.println("91+8465842594");
			out.println("<br>");
			out.println("8 a.m. to 5 p.m. xyz, Monday through Friday");

		}
		if (!x.equals("t")) {
			out.println("<br><br><br><br>");
			out.println("<h1>FOR DOCTOR APPOINTMENT</h1>");
			out.println("<br>");
			out.println("<b>online doctor:</b>");
			out.println("<br>");
			out.println("91+8465842594");
			out.println("<br>");
			out.println("8 a.m. to 5 p.m. xyz, Monday through Friday");
		}
		out.println("To go back click on this link");
		out.println("<a href='http://localhost:8083/doctor/Servletm'>click me</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
