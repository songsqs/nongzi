package com.shennong.nongzi.web;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shennong.nongzi.server.service.account.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "createCustomerAccount", method = RequestMethod.POST)
	public String createAccount(@RequestParam(value = "customerId", required = true) Integer customerId) {
		return null;
	}

}
