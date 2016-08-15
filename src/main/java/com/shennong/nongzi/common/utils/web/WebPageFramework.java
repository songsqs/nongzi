package com.shennong.nongzi.common.utils.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

/**
 * 通用的web框架
 * 
 * @author sqs
 *
 */
public abstract class WebPageFramework {

	private static final int DEFAULT_ERROR_CODE = 1;

	/**
	 * 子类需继承这个方法实现自己的特性
	 * 
	 * @param model
	 * @return
	 */
	protected abstract String getPage(Model model);

	public String run(HttpServletRequest request, Model model) {
		String result = runImpl(request, model);
		return result;
	}

	public String runImpl(HttpServletRequest request, Model model) {
		if (request == null) {
			return errorPage("request==null");
		}
		if (model == null) {
			return errorPage("model==null");
		}

		try {
			String result = getPage(model);
			return result;
		} catch (Exception e) {
			String result = errorPage(e.getMessage());
			e.printStackTrace(System.err);
			return result;
		}
	}

	private static String errorPage(int code, String msg) {
		return "error";
	}

	private static String errorPage(String msg) {
		return errorPage(DEFAULT_ERROR_CODE, msg);
	}

}
