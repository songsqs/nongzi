package com.shennong.nongzi.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		return "account/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginDo(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		SavedRequest request = (SavedRequest) SecurityUtils.getSubject().getSession()
				.getAttribute(WebUtils.SAVED_REQUEST_KEY);
		return "account/login";
	}

}
