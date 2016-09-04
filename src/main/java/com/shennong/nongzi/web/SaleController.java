package com.shennong.nongzi.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shennong.nongzi.common.utils.StringUtil;
import com.shennong.nongzi.common.utils.web.Page;
import com.shennong.nongzi.server.bean.entity.Customer;
import com.shennong.nongzi.server.bean.entity.Product;
import com.shennong.nongzi.server.bean.entity.Sale;
import com.shennong.nongzi.server.service.customer.CustomerService;
import com.shennong.nongzi.server.service.product.ProductService;
import com.shennong.nongzi.server.service.sale.SaleService;

@Controller
@RequestMapping("sale")
public class SaleController {

	@Autowired
	private SaleService saleService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@RequestMapping("list")
	public String getSale(HttpServletRequest request, Model model,
			@RequestParam(value = "customerName", required = false) String customerName,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "timeBegin", required = false) String timeBegin,
			@RequestParam(value = "timeEnd", required = false) String timeEnd,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
			@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
		Map<String, Object> param = new HashMap<>();
		param.put("customerName", StringUtil.realString(customerName));
		param.put("prodctName", StringUtil.realString(productName));
		param.put("timeBegin", StringUtil.realString(timeBegin));
		param.put("timeEnd", StringUtil.realString(timeEnd));

		Page page = new Page(pageIndex, pageSize);

		// 閲囩敤浼犻�掑璞＄殑鏂规硶鎿嶄綔page瀵硅薄
		List<Sale> saleList = saleService.getSaleListByParam(param, page);

		model.addAttribute("saleList", saleList);
		model.addAttribute("page", page);

		return "sale/sale_table_list";
	}

	@RequestMapping("add")
	public String addSale(HttpServletRequest request, Model model) {

		List<Customer> customerList = customerService.getAllCustomerList();
		List<Product> productList = productService.getAllProductList();

		model.addAttribute("customerList", customerList);
		model.addAttribute("productList", productList);

		return "sale/sale_add";
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String addSaleDo(HttpServletRequest request, Sale sale) {
		saleService.addSale(sale);
		return "sale/sale_add";
	}

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteSaleDo(HttpServletRequest request,
			@RequestParam(value = "saleId", required = true) Integer saleId) {
		int result = saleService.deleteSaleBySaleId(saleId);
		return String.valueOf(result);
	}

	@RequestMapping("/chart/general")
	public String getSaleGeneralChart(HttpServletRequest request, Model model,
			@RequestParam(value = "customerName", required = false) String customerName,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "timeBegin", required = false) String timeBegin,
			@RequestParam(value = "timeEnd", required = false) String timeEnd) {

		Map<String, Object> param = new HashMap<>();
		param.put("customerName", StringUtil.realString(customerName));
		param.put("prodctName", StringUtil.realString(productName));
		param.put("timeBegin", StringUtil.realString(timeBegin));
		param.put("timeEnd", StringUtil.realString(timeEnd));

		String option = saleService.getSaleGeneralOptionByParam(param);

		model.addAttribute("option", option);

		return "sale/sale_general_chart";
	}

	@RequestMapping("/chart/product")
	public String getProductChart(HttpServletRequest request, Model model,
			@RequestParam(value = "productId", required = false) Integer productId,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "timeBegin", required = false) String timeBegin,
			@RequestParam(value = "timeEnd", required = false) String timeEnd) {

		Map<String, Object> param = new HashMap<>();
		param.put("productId", productId);
		param.put("productName", StringUtil.realString(productName));
		param.put("timeBegin", StringUtil.realString(timeBegin));
		param.put("timeEnd", StringUtil.realString(timeEnd));

		Map<String, String> optionMap = saleService.getSaleProductOptionByParam(param);

		model.addAllAttributes(optionMap);

		return "sale/sale_product_chart";
	}

	@RequestMapping("/chart/customer")
	public String getCustomerChart(HttpServletRequest request, Model model,
			@RequestParam(value = "customerId", required = false) Integer customerId,
			@RequestParam(value = "customerName", required = false) String customerName,
			@RequestParam(value = "timeBegin", required = false) String timeBegin,
			@RequestParam(value = "timeEnd", required = false) String timeEnd) {

		Map<String, Object> param = new HashMap<>();
		param.put("customerId", customerId);
		param.put("customerName", StringUtil.realString(customerName));
		param.put("timeBegin", StringUtil.realString(timeBegin));
		param.put("timeEnd", StringUtil.realString(timeEnd));

		Map<String, String> optionMap = saleService.getSaleCustomerOptionByParam(param);

		model.addAllAttributes(optionMap);

		return "sale/sale_customer_chart";
	}

}
