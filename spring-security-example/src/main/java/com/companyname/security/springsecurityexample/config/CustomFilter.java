package com.companyname.security.springsecurityexample.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component // no need to annotate this because it is already marked as Bean in mehtod
public class CustomFilter implements Filter {// Servlet Filter

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init::called");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter::called");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		Principal userprincipal = httpServletRequest.getUserPrincipal();
		System.out.println(userprincipal);
		chain.doFilter(httpServletRequest, response);

	}

	@Override
	public void destroy() {
		System.out.println("destroy::called");

	}

}
