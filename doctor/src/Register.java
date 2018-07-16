import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
// @WebServlet(asyncSupported = true, urlPatterns = { "/Register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("UNAME"), p = request.getParameter("PWD"), e = request.getParameter("email"),
				b = request.getParameter("bg"), c = request.getParameter("con"), g = request.getParameter("GENDER"),
				a = request.getParameter("age");

		/*
		 * String from = "asranaseem98@gmail.com"; String password = "nothing@23asra";
		 * String to = e; String sub = "online doctor"; String msg =
		 * "Registered successfully ...thank you for registering" + "\n" +
		 * "BE 3/4 CSE C-1\n" + "160115733002" + "\t" + "160115733004"; // Get
		 * properties object Properties props = new Properties();
		 * props.put("mail.smtp.host", "smtp.gmail.com");
		 * props.put("mail.smtp.socketFactory.port", "465");
		 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.port", "465"); //
		 * get Session Session session = Session.getDefaultInstance(props, new
		 * javax.mail.Authenticator() { protected PasswordAuthentication
		 * getPasswordAuthentication() { return new PasswordAuthentication(from,
		 * password); } }); // compose message try { MimeMessage message = new
		 * MimeMessage(session); message.addRecipient(Message.RecipientType.TO, new
		 * InternetAddress(to)); message.setSubject(sub); message.setText(msg); // send
		 * message Transport.send(message);
		 * System.out.println("message sent successfully"); } catch (MessagingException
		 * e1) { throw new RuntimeException(e1); }
		 */

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "keerthi");
			out.println("<h1>" + n + p + a + g + b + e + c + "</h1>");
			Statement stmt = con.createStatement();
			String str1 = "INSERT INTO login values('" + n + "','" + p + "','" + g + "','" + a + "','" + b + "','" + e
					+ "','" + c + "')";
			stmt.executeUpdate(str1);
			if (true) {
				// con.close();
				HttpSession session1 = request.getSession();
				String d = session1.getId();
				session1.setAttribute("name", n);
				session1.setAttribute("value", d);
				session1.setMaxInactiveInterval(30 * 60);
				// RequestDispatcher rd=request.getRequestDispatcher("Servletm");
				// rd.forward(request,response);
				response.sendRedirect("Servletm");

			}

			con.close();
		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

}
