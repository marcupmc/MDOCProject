package filters;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CheckValideFilter
 */
public class CheckValideFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public CheckValideFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest r = (HttpServletRequest) request;
		
		Pattern p1 = Pattern.compile("[a-z]*.css");
		Pattern p2  = Pattern.compile("[a-z]*.js");
		Pattern p3 = Pattern.compile("[a-z]*.png");
		
		Matcher m1 = p1.matcher(r.getServletPath().toString());
		Matcher m2 = p2.matcher(r.getServletPath().toString());
		Matcher m3 = p3.matcher(r.getServletPath().toString());
		if(m1.find() || m2.find()|| m3.find()){
			chain.doFilter(request, response);

		}

		else if(r.getServletPath().equals("/LoginServlet"))
			chain.doFilter(request, response);
		else{
			if(r.getSession().getAttribute("login")!=null)
				chain.doFilter(request, response);
			else
				request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
