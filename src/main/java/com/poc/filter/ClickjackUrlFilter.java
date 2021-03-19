package com.poc.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class ClickjackUrlFilter implements Filter{
	private static Logger logger = Logger.getLogger(ClickjackUrlFilter.class.getName());
	boolean flag = true;
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		if(response.containsHeader("SAMEORIGIN"))
		{
			response.setHeader("X-Frame-Options", "");
			logger.info("contains HEader same origin");
		}else {

			response.setHeader("X-Frame-Options", "SAMEORIGIN");
			logger.info("doesn't contains");
		}
		chain.doFilter(servletRequest, servletResponse);
	}
	@Override
			  public void destroy() {}

	  @Override
	  public void init(FilterConfig arg0) throws ServletException {}

	}
