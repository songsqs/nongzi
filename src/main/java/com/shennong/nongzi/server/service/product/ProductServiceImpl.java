package com.shennong.nongzi.server.service.product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.common.utils.web.Page;
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

	@Override
	public List<Product> getProductListByParam(Map<String, Object> param, Page page) {
		Integer pageIndex = page.getPageIndex();
		Integer pageSize = page.getPageSize();

		// page已经保证pageIndex>=1
		Integer begin = (pageIndex - 1) * pageSize;
		// limit=pageSize+1用于确定是否有下一页
		Integer limit = pageSize + 1;

		List<Product> productList = productManager.selectProdyctListByParamWithLimit(param, begin, limit);

		boolean isEmpty = CollectionUtils.isEmpty(productList);
		if (isEmpty || pageIndex <= 1) {
			page.setHasPrevious(Boolean.FALSE);
		} else {
			page.setHasPrevious(Boolean.TRUE);
		}

		if (isEmpty || productList.size() <= pageSize) {
			page.setHasNext(Boolean.FALSE);
		} else {
			page.setHasNext(Boolean.TRUE);
			productList.remove(productList.size() - 1);
		}

		return productList;
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
