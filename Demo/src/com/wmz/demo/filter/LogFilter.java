package com.wmz.demo.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class LogFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain)
			throws IOException, ServletException {
		String ipAddress = request.getRemoteAddr(); 
		System.out.println("ip:"+ipAddress + ",date="+new Date().toString());
		chain.doFilter(request, reponse);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String testParam = config.getInitParameter("test-param"); 
		System.out.println("test Param:"+testParam);
	}

	

}
