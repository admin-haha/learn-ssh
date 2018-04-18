package com.system.intercepter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestHandleIntercepter extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(RequestHandleIntercepter.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("进入拦截器.........");
//		Users users = (Users) request.getSession().getAttribute(AppConstant.SESSION_USER_KEY);
		String method = request.getMethod();
		String url = request.getServletPath();
		Enumeration<String> paramNames = request.getParameterNames();
		StringBuffer sb = new StringBuffer();
		while(paramNames.hasMoreElements()){
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			sb.append(paramName)
			  .append("=").append(paramValue);
			if(paramNames.hasMoreElements()){
				sb.append(",");
			}
		}
		logger.info("\n"+"******"+"\n"+"*请求URL:"+url+"\n"+"*请求METHOD:"+method+"\n"+"*请求参数："+"\n"+"**"+sb.toString()+"\n"+"******");
		
		if("/login".equals(url)) {
			return true;
		}
		
		
		// 如果用户已经绑定过 放行
		return true;
	}

}
