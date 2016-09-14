package com.shennong.nongzi.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shennong.nongzi.server.bean.entity.ShiroUser;
import com.shennong.nongzi.server.service.account.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "createCustomerAccount.do", method = RequestMethod.POST)
	@ResponseBody
	@RequiresRoles("admin")
	public String createAccount(@RequestParam(value = "customerId", required = true) Integer customerId) {
		accountService.createCustomerAccount(customerId);
		return "success";
	}

	@RequestMapping(value = "changePassword")
	public String changePassword() {
		return "account/change_password";
	}

	@RequestMapping(value = "changePassword.do", method = RequestMethod.POST)
	@ResponseBody
	public String changePasswordDo(@RequestParam(value = "originPassword", required = true) String originPassword,
			@RequestParam(value = "newPassword", required = true) String newPassword) {

		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();

		Integer accountId = shiroUser.getId();

		boolean result = accountService.changePassword(accountId, originPassword, newPassword);

		return Boolean.toString(result);
	}

}
