/**
 * Copyright(C) 2020 Luvina Software
 * CharsetEncodingFilter.java, 14/08/2020 Nguyễn Mạnh Quân
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

import manageuser.utils.Constant;

/**
 * Mô tả: Xử lý set CharsetEncoding
 * 
 * @author Nguyễn Mạnh Quân
 */
public class CharsetEncodingFilter implements Filter {

    /**
     * Constructor mặc định
     */
    public CharsetEncodingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * Xử lý set CharsetEncoding
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding(Constant.CHARSET_ENCODING_UTF8);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
