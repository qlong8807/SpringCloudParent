package com.java.zz.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public Object run() {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
		String parameter = request.getParameter("accessToken");
		if(null == parameter) {
			logger.warn("access token is empty");
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(401);
			return null;
		}
		logger.info("access token is OK");
		return null;
	}

	/* 
	 * true则会调用上面的run方法。
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/* 
	 * 同一阶段存在多个过滤器时，过滤器的执行顺序
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/* 
	 * 决定过滤器在哪个阶段执行。pre为在路由之前。
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
