package com.shennong.nongzi.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.shennong.nongzi.server.bean.entity.Product;
import com.shennong.nongzi.server.service.product.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("add")
	public String addProduct() {
		System.out.println("add product");
		return "product/product_add";
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String addProductDo(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
			Product product) {
		return "product/product_add";
	}

	@RequestMapping(value = "list")
	public String listProduct(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		List<Product> productList = productService.getAllProductList();
		model.addAttribute("productArray", productList);
		return "product/product_list";
	}

	@RequestMapping(value = "edit")
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
	public String editProductDo(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes,
			Product product) {
		productService.updateProductByProductId(product);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	@ResponseBody
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
