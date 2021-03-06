package com.shennong.nongzi.web;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.common.utils.web.Page;
import com.shennong.nongzi.server.bean.entity.Product;
import com.shennong.nongzi.server.service.product.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	private static final Logger logger=LoggerFactory.getLogger(ProductController.class);

	@RequestMapping("add")
	@RequiresRoles("admin")
	public String addProduct() {
		logger.info("addProduct");
		return "product/product_add";
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@RequiresRoles("admin")
	public String addProductDo(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
			Product product) {
		
		logger.info("addProductDo,product:"+product);
		
		productService.addProduct(product);
		
		return "redirect:/product/list";
	}

	@RequestMapping(value = "list")
	public String listProduct(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "manufacturer", required = false) String manufacturer,
			@RequestParam(value = "priceMin", required = false) BigDecimal priceMin,
			@RequestParam(value = "priceMax", required = false) BigDecimal priceMax,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
			@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {

		Page page = new Page(pageIndex, pageSize);

		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("manufacturer", manufacturer);
		param.put("priceMin", priceMin);
		param.put("priceMax", priceMax);

		List<Product> productList = productService.getProductListByParam(param, page);
		model.addAttribute("productArray", productList);
		model.addAttribute("page", page);

		return "product/product_list";
	}

	@RequestMapping(value = "edit")
	@RequiresRoles("admin")
	public String editProduct(HttpServletRequest request, Model model,
			@RequestParam(value = "productId", required = true) Integer productId) {
		Product product = productService.getProductByProductId(productId);
		if (product == null) {
			throw new NongziException(RES_STATUS.PRODUCT_NOT_EXITED);
		}

		model.addAttribute("product", product);

		return "product/product_edit";
	}

	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@RequiresRoles("admin")
	public String editProductDo(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
			Product product) {
		productService.updateProductByProductId(product);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	@ResponseBody
	@RequiresRoles("admin")
	public String deleteProductDo(HttpServletRequest request,
			@RequestParam(value = "productId", required = true) Integer productId) {
		int result = productService.deleteProductByProductId(productId);
		return String.valueOf(result);
	}

	@RequestMapping(value = "getProduct.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getProductDo(HttpServletRequest request, @RequestParam(value = "name", required = true) String name) {

		List<Product> productList = productService.getProductListByName(name);

		return JSONObject.toJSONString(productList);
	}

}
