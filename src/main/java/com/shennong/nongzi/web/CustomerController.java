package com.shennong.nongzi.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.common.utils.web.Page;
import com.shennong.nongzi.server.bean.entity.Customer;
import com.shennong.nongzi.server.bean.entity.CustomerWithAccount;
import com.shennong.nongzi.server.bean.entity.ShiroUser;
import com.shennong.nongzi.server.bean.enums.AccountTypeEnum;
import com.shennong.nongzi.server.service.customer.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private static final DateFormat FORMATER = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping("add")
	@RequiresRoles("admin")
	public String addCustomer() {
		return "customer/customer_add";
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@RequiresRoles("admin")
	public String addCustomerDo(Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}

	@RequestMapping("list")
	public String listProduct(HttpServletRequest request, Model model,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "mobile", required = false) String mobile,
			@RequestParam(value = "village", required = false) String village,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
			@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {

		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("mobile", mobile);
		param.put("village", village);

		Page page = new Page(pageIndex, pageSize);

		List<Customer> customerList = customerService.getCustomerListByParam(param, page);

		List<CustomerWithAccount> customerWithAccountList = customerService.conversionCustomerWithAccount(customerList);

		model.addAttribute("customerList", customerWithAccountList);
		model.addAttribute("page", page);

		return "customer/customer_list";
	}

	@RequestMapping("edit")
	@RequiresRoles(value = { "admin", "normal" }, logical = Logical.OR)
	public String editProduct(HttpServletRequest request, Model model,
			@RequestParam(value = "customerId", required = true) Integer customerId) {
		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();

		// 如果用户不是管理员账户,则只能编辑自己的信息
		if (Integer.valueOf(AccountTypeEnum.ADMIN.getType()).equals(shiroUser.getType()) == false) {
			customerId = shiroUser.getUserId();
			if (customerId == null) {
				throw new NongziException(RES_STATUS.CUSTOMER_NOT_EXITED);
			}
		}

		Customer customer = customerService.getCustomerByCustomerId(customerId);
		if (customer == null) {
			throw new NongziException(RES_STATUS.CUSTOMER_NOT_EXITED);
		}

		model.addAttribute("customer", customer);
		Date birthday = customer.getBirthday();
		if (birthday != null) {
			model.addAttribute("birthday", FORMATER.format(customer.getBirthday()));
		}

		return "customer/customer_edit";
	}

	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@RequiresRoles(value = { "admin", "normal" }, logical = Logical.OR)
	public String editCustomerDo(Customer customer) {
		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();

		// 如果不是管理员账户,则只能编辑自己的信息
		if (Integer.valueOf(AccountTypeEnum.ADMIN.getType()).equals(shiroUser.getType()) == false) {
			Integer customerId = shiroUser.getUserId();
			if (customerId == null) {
				throw new NongziException(RES_STATUS.CUSTOMER_NOT_EXITED);
			}
			customer.setCustomerId(customerId);
		}

		customerService.updateCustomerByCustomerId(customer);
		
		return "redirect:/customer/list";
	}

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	@ResponseBody
	@RequiresRoles("admin")
	public String deleteCustomerDo(HttpServletRequest request,
			@RequestParam(value = "customerId", required = true) Integer customerId) {
		int result = customerService.deleteCustomerByCustomerId(customerId);
		return String.valueOf(result);
	}

	@RequestMapping(value = "getCustomer.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getCustomerDo(HttpServletRequest request,
			@RequestParam(value = "name", required = true) String name) {
		List<Customer> customerList = customerService.getCustomerListByName(name);

		return JSONObject.toJSONString(customerList);
	}

}
