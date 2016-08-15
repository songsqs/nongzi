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

import com.shennong.nongzi.common.utils.StringUtil;
import com.shennong.nongzi.server.bean.entity.Sale;
import com.shennong.nongzi.server.service.sale.SaleService;

@Controller
@RequestMapping("sale")
public class SaleController {


	@Autowired
	private SaleService saleService;

	@RequestMapping("list")
	public String getSale(HttpServletRequest request, Model model,
			@RequestParam(value = "customerName", required = false) String customerName,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "timeBegin", required = false) String timeBegin,
			@RequestParam(value = "timeEnd", required = false) String timeEnd) {
		Map<String, Object> param = new HashMap<>();
		param.put("customerName", StringUtil.realString(customerName));
		param.put("prodctName", StringUtil.realString(productName));
		param.put("timeBegin", StringUtil.realString(timeBegin));
		param.put("timeEnd", StringUtil.realString(timeEnd));

		List<Sale> saleList = saleService.getSaleListByParam(param);

		model.addAttribute("saleList", saleList);

		return "sale/sale_table_list";
	}

	@RequestMapping("add")
	public String addSale() {
		return "sale/sale_add";
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String addSaleDo(HttpServletRequest request, Sale sale) {
		saleService.addSale(sale);
		return "sale/sale_add";
	}

}
