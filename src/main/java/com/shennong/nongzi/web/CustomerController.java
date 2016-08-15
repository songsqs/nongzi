package com.shennong.nongzi.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.shennong.nongzi.server.bean.entity.Customer;
import com.shennong.nongzi.server.service.customer.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private static final DateFormat FORMATER = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping("add")
	public String addCustomer() {
		return "customer/customer_add";
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String addCustomerDo(Customer customer) {
		System.out.println(customer);
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}

	@RequestMapping("list")
	public String listProduct(HttpServletRequest request, Model model) {
		List<Customer> customerList = customerService.getAllCustomerList();

		model.addAttribute("customerList", customerList);
		return "customer/customer_list";
	}

	@RequestMapping("edit")
	public String editProduct(HttpServletRequest request, Model model,
			@RequestParam(value = "customerId", required = true) Integer customerId) {
		Customer customer = customerService.getCustomerByCustomerId(customerId);
		if (customer == null) {
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}

		model.addAttribute("customer", customer);
		Date birthday = customer.getBirthday();
		if (birthday != null) {
			model.addAttribute("birthday", FORMATER.format(customer.getBirthday()));
		}

		return "customer/customer_edit";
	}

	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	public String editCustomerDo(Customer customer) {
		customerService.updateCustomerByCustomerId(customer);
		
		return "redirect:/customer/list";
	}

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	@ResponseBody
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

		System.out.println("getCustomerDo,name:" + name + ",result:" + customerList);

		return JSONObject.toJSONString(customerList);
	}

}
