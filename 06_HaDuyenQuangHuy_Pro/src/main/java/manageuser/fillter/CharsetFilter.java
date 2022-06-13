package manageuser.fillter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageuser.utils.Constant;

/**
 * Servlet Filter implementation class CharsetFilter
 */
@WebFilter("/CharsetFilter")
public class CharsetFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CharsetFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		try {
			if (req.getCharacterEncoding() == null) {
				// set encoding lên request
				req.setCharacterEncoding("UTF-8");
			}

			// pass the request along the filter chain
			chain.doFilter(request, response);
			
		} catch (Exception e) {
			System.out.println("Error: CharsetFilter.doFilter " + e.getMessage());
			resp.sendRedirect(req.getContextPath() + Constant.SYSTEM_ERROR_LOCAL + "?type=" + "ER015");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
