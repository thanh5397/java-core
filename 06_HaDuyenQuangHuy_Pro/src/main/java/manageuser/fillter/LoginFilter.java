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
import javax.servlet.http.HttpSession;

import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
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
	 * 
	 *      Filter checkLogin, nếu chưa đăng nhập điều hướng về màn hình ADM001
	 * @param ServletRequest request
	 * @param ServletResponse response
	 * @param FilterChain chain
	 * 
	 * @return none
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String URIRequest = req.getRequestURI();
		String loginPath = req.getContextPath() + "/" + Constant.URL_LOGIN;
		String systemErrorPath = req.getContextPath() + "/" + Constant.URL_SYS_ERROR;
		try {
			if (!Common.compareString(URIRequest, loginPath) && (!Common.compareString(URIRequest, systemErrorPath))) {
				if (Common.checkLogin(session)) {
					chain.doFilter(request, response);
				} else {
					resp.sendRedirect(req.getContextPath() + "/" + Constant.URL_LOGIN);
				}
			} else {
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			System.out.println("Error: LoginFilter.doFilter " + e.getMessage());
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
