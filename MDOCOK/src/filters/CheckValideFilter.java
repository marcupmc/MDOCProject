package filters;

import java.io.IOException;
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
		if(r.getServletPath().equals("/css/style.css")){
			chain.doFilter(request, response);
			System.out.println();
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
