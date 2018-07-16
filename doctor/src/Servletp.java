
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servletp
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Servletp" })
public class Servletp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
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

		int a1 = Integer.parseInt(request.getParameter("1")), a2 = Integer.parseInt(request.getParameter("2")),
				a3 = Integer.parseInt(request.getParameter("3")), a4 = Integer.parseInt(request.getParameter("4")),
				a5 = Integer.parseInt(request.getParameter("5")), a6 = Integer.parseInt(request.getParameter("6")),
				a7 = Integer.parseInt(request.getParameter("7")), a8 = Integer.parseInt(request.getParameter("8")),
				a9 = Integer.parseInt(request.getParameter("9")), a10 = Integer.parseInt(request.getParameter("10"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "onlinedoctor",
					"keerthi");
			Statement stmt = con.createStatement();
			int sum = a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10;
			if (sum < 21) {
				out.println("<center><h1>under 21 points:</h1></center>");

				out.println("people think you are shy,nervous,and indecisive someone who needs looking after,\n"
						+ "who always wants someone else to make the decisions and who does'nt want to get involved with\n"
						+ "anyone or anything.they see you as a worrier who always ees problems that don't exist.Some people\n"
						+ "think you're boring.Only those who know you well know that you aren't.");
			} else if (sum >= 21 && sum <= 30) {
				out.println("<center><h1>21 to 30 points:</h1></center>");

				out.println(
						"your friends see you as painstaking and fussy.They see you as very cautious,extremely careful...\n"
								+ "A slow and steady plodder.It'd really surprise them if you ever did something impulsively or on the spur of\n"
								+ "moment, expecting you to examine every thing carefully from every angle and then ,usually decide against it.\n"
								+ "They think this reaction is caused partly by your careful nature.");

			} else if (sum >= 31 && sum <= 40) {
				out.println("<center><h1>31 to 40 points:</h1></center>");

				out.println(
						"others see you as sensible,cautious careful and practical.they see you as clever,gifted,or talented,but modest.\n"
								+ "Not a person who makes friends too quicky or easily,but somwone who's extremely loyal to friends you to make and expect the\n"
								+ "same loyality in return,those who really get to know you realize it takes alot to shake your trust in your friends,but equally\n"
								+ "that it takes you a long time to get over it that trust is ever broken.");
			} else if (sum >= 41 && sum <= 50) {
				out.println("<center><h1>41 to 50 points:</h1></center>");

				out.println(
						"others see you as fresh,lively,charming, amusing,and always interesting;someone who's constantly in the center\n"
								+ "of attention,but sufficiently well balenced not to let it go to their head,they also see you as kind,considerate,and\n"
								+ "understanding;someone who will always cheer them up and help them out.");
			} else if (sum >= 51 && sum <= 60) {
				out.println("<center><h1>51 to 60 points:</h1></center>");

				out.println(
						"others see you as an exciting,highly volatile,rather impulsive personality;a natural leader,who's quick to\n"
								+ "make decisions,though always not the right ones. they see you bold and adventuresome,someone who will try anything once;\n"
								+ "someone who takes chances and enjoys adventure.they enjoy being in your company because of the excitement you radiate.");
			}

			else if (sum > 60) {
				out.println("<center><h1>over 60 points :</h1></center>");

				out.println(
						"others see you as somebody they should \"handle with care\" you're seen as vain,self-centered,and who is\n"
								+ "extremely dominant.Others may admire you,wishing they could be more like you,but don't always trust you ,hesitating to\n"
								+ "become too deeply involved with you.");
			}

			con.close();
		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

}
