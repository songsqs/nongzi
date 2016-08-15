package com.shennong.nongzi.server.service.product;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Product;
import com.shennong.nongzi.server.dal.manager.ProductManager;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductManager productManager;

	@Override
	public void addProduct(Product product) {
		List<Product> productList = getAllProductList();
		if (!CollectionUtils.isEmpty(productList)) {
			String addedSignKey = generateSignKey(product);
			for (Product productT : productList) {
				String signKey = generateSignKey(productT);
				if (addedSignKey.equals(signKey)) {
					throw new NongziException(RES_STATUS.PRODUCT_ADDED);
				}
			}
		}

		Date date = new Date();
		product.setCreateTime(date);
		product.setUpdateTime(date);
		product.setEnable((byte) 1);

		productManager.insert(product);

	}

	@Override
	public void addProductIgnoreDuplicate(Product product) {
		productManager.insert(product);
	}

	@Override
	public List<Product> getAllProductList() {
		List<Product> result = productManager.getAllProductList();
		return result;
	}

	private String generateSignKey(Product product) {
		return product.getName();
	}

	@Override
	public Product getProductByProductId(Integer productId) {
		Product product = productManager.selectProductByProductId(productId);
		return product;
	}

	@Override
	public Product updateProductByProductId(Product product) {
		product.setUpdateTime(new Date());
		productManager.updateByPrimaryKeySelective(product);
		return product;
	}

	@Override
	public int deleteProductByProductId(Integer productId) {
		int result = productManager.deleteProductByProductId(productId);
		return result;
	}

	@Override
	public List<Product> getProductListByName(String name) {
		List<Product> productList = productManager.selectProductListByName(name);
		return productList;
	}

}
