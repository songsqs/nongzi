package com.shennong.nongzi.server.frame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.shennong.nongzi.common.utils.web.WebPageFramework;
import com.shennong.nongzi.server.bean.entity.Product;
import com.shennong.nongzi.server.service.product.ProductService;

public class ProductAddDoFrame extends WebPageFramework {

	@Autowired
	private ProductService productService;

	private Product product;

	public ProductAddDoFrame(Product product) {
		this.product = product;
	}

	@Override
	protected String getPage(Model model) {
		productService.addProduct(product);
		return "product/product_add";
	}

}
