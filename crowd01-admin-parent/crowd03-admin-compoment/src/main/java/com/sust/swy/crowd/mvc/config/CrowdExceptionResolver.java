package com.sust.swy.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.util.CrowdUtil;
import com.sust.swy.crowd.util.ResultEntity;

//基于注解的异常处理器类
@ControllerAdvice
public class CrowdExceptionResolver {

	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String viewName = "system-error";
		return commonResolve(viewName, exception, request, response);
	}
	
	// @ExceptionHandler将一个具体的异常类型和一个方法关联起来
	private ModelAndView commonResolve(String viewName, Exception exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		boolean judgeResult = CrowdUtil.judgeRequestType(request);
		// Ajax请求
		if (judgeResult) {
			// 创建ResultEntity对象
			ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
			// 创建Gson对象
			Gson gson = new Gson();
			// 转换为JSON字符串
			String json = gson.toJson(resultEntity);
			// 返回给浏览器
			response.getWriter().write(json);
			return null;
		}
		// 创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		// 将Exception对象存入模型
		modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);
		// 设置对应的视图名称
		modelAndView.setViewName(viewName);
		return modelAndView;
	}

}
