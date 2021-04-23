package com.sust.swy.crowd.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sust.swy.crowd.constant.AccessPassResources;
import com.sust.swy.crowd.constant.CrowdConstant;

@Component
public class CrowdAccessFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String servletPath = request.getServletPath();
		boolean containsResult = AccessPassResources.PASS_RES_SET.contains(servletPath);
		if (containsResult) {
			return false;
		}
		return !AccessPassResources.judgeCurrentServletPathWetherStaticResource(servletPath);
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		HttpSession session = request.getSession();
		Object loginMember = session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
		if (loginMember == null) {
			HttpServletResponse response = requestContext.getResponse();
			session.setAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
			try {
				response.sendRedirect("/auth/member/to/login/page");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
