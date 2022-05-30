/**
 * Copyright(C) 2020 Luvina Software
 * LoginFilter.java, 14/08/2020 Nguyễn Mạnh Quân
 */
package manageuser.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.utils.Common;
import manageuser.utils.Constant;

/**
 * Mô tả: Xử lý lọc đăng nhập
 * 
 * @author Nguyễn Mạnh Quân
 */
public class LoginFilter implements Filter {

    /**
     * Constructor mặc định
     */
    public LoginFilter() {
    }

	/**
	 * Xử lý lọc đăng nhập
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			String servletPath = req.getServletPath();
			HttpSession session = req.getSession();
			boolean checkSystemError015 = false;
			if (Common.compareString(servletPath, Constant.SYSTEM_ERROR_DO)) {
				String queryString = req.getQueryString();
				String typeEr015 = Constant.PARAM_TYPE + "=" + Constant.ER015; 
				if (Common.compareString(typeEr015, queryString)) {
					checkSystemError015 = true;
				}
			}
			if (checkSystemError015 || Common.compareString(servletPath, Constant.LOGIN_DO) || Common.checkLogin(session)) {
				chain.doFilter(request, response);
			} else {			
				res.sendRedirect(req.getContextPath() + Constant.LOGIN_DO);
			}
		} catch (Exception e) {
			System.out.println("LoginFilter: doFilter :" + e.getMessage());
			res.sendRedirect(req.getContextPath() + Constant.SYSTEM_ERROR_DO + "?type=" + Constant.ER015);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void destroy() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
