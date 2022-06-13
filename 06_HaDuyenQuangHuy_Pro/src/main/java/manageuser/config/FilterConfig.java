/**
 * Copyright(C) 2020 Luvina Software
 * FilterConfig.java, 09/29/2020 HaDuyenQuangHuy
 */
package manageuser.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import manageuser.fillter.CharsetFilter;
import manageuser.fillter.LoginFilter;

/**
 * Xử lý liên quan đến các Filter
 * 
 * @author Ha Duyen Quang Huy
 */
@Configuration
public class FilterConfig {
	/**
	 * Xử lý CharsetFilter
	 * 
	 * return registrantionBean
	 */
	@Bean
	public FilterRegistrationBean<CharsetFilter> charsetFilterBean() {
		FilterRegistrationBean<CharsetFilter> registrationBean = new FilterRegistrationBean<CharsetFilter>();
		CharsetFilter charsetFilter = new CharsetFilter();
		registrationBean.setFilter(charsetFilter);
		registrationBean.addUrlPatterns("*.do");
		registrationBean.setOrder(1); // set precedence
		return registrationBean;
	}

	/**
	 * Xử lý LoginFilter
	 * 
	 * return registrantionBean
	 */
	@Bean
	public FilterRegistrationBean<LoginFilter> loginFilterBean() {
		FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<LoginFilter>();
		LoginFilter loginFilter = new LoginFilter();
		registrationBean.setFilter(loginFilter);
		registrationBean.addUrlPatterns("*.jsp");
		registrationBean.addUrlPatterns("*.do");
		registrationBean.setOrder(2); // set precedence
		return registrationBean;
	}
}
