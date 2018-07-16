
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Displayfiltercount
 */
@WebFilter("/Displayfiltercount")
public class Displayfiltercount implements Filter {

	FilterConfig config;

	public void init(FilterConfig x) {
		config = x;
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		ServletContext context = config.getServletContext();
		Integer count = (Integer) context.getAttribute("c");
		if (count == null) {
			count = new Integer(0);
		}
		count = new Integer(count.intValue() + 1);
		context.setAttribute("c", count);
		/*
		 * HttpSession session = req.getSession(false); if(session!=null) {
		 * HttpServletResponse response = (HttpServletResponse) res;
		 * response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		 * // HTTP 1.1. response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		 * response.setDateHeader("Expires", 0); }
		 */
		chain.doFilter(req, res);
	}

	public void destroy() {
	}

}
