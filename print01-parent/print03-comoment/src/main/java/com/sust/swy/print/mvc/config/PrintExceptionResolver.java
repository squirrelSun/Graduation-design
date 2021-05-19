package com.sust.swy.print.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.exception.LoginAcctAlreadyInUseForUpdateException;
import com.sust.swy.print.constant.util.PrintUtil;
import com.sust.swy.print.constant.util.ResultEntity;

//基于注解的异常处理器类
@ControllerAdvice
public class PrintExceptionResolver {

	@ExceptionHandler(value = LoginAcctAlreadyInUseForUpdateException.class)
	public ModelAndView resolveLoginAcctAlreadyInUseForUpdateException(
			LoginAcctAlreadyInUseForUpdateException exception, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String viewName = "system-error";
		return commonResolve(viewName, exception, request, response);
	}

	private ModelAndView commonResolve(String viewName, Exception exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		boolean judgeResult = PrintUtil.judgeRequestType(request);
		if (judgeResult) {
			ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
			Gson gson = new Gson();
			String json = gson.toJson(resultEntity);
			response.getWriter().write(json);
			return null;
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(PrintConstant.ATTR_NAME_EXCEPTION, exception);
		modelAndView.setViewName(viewName);
		return modelAndView;
	}

}
