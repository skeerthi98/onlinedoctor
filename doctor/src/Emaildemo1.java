
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Emaildemo1
 */
@WebServlet("/Emaildemo1")
public class Emaildemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String y = req.getParameter("UNAME");
		String host = "smtp.gmail.com", to = "";
		String from = "onlinedoctorcbit@gmail.com@gmail.com";
		final String user = "onlinedoctorcbit";
		final String password = "online733";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "onlinedoctor_conn",
					"keerthi");
			Statement stmt = con.createStatement();
			String x = "select email from login where username='" + y + "'";
			ResultSet rs2 = stmt.executeQuery(x);
			while (rs2.next())
				to = rs2.getString(1);
			out.println(to);

			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("javatpoint");
				message.setText("This is simple program of sending email using JavaMail API");
				Transport.send(message);
				if (true) {
					System.out.println("message sent successfully...");
					RequestDispatcher rd = req.getRequestDispatcher("Servletm");
					rd.forward(req, res);
				}
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			con.close();
		}

		catch (Exception e2) {
			System.out.println(e2);
		}

	}

}
