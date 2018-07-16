

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sunburn
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/sunburn" })
public class sunburn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession session = req.getSession(false);
		if(session==null)
			out.println("no session");
		else		
		{
			RequestDispatcher rd=req.getRequestDispatcher("sunburn.html");
			rd.forward(req,res);
		}
	}   
}
