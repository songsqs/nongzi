package com.shennong.nongzi.server.dal.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Product;
import com.shennong.nongzi.server.dal.dao.ProductMapper;

@Component
public class ProductManager {

	@Autowired
	private ProductMapper productMapper;

	public Product insert(Product product) {
		try {
			productMapper.insert(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Product> getAllProductList() {
		try {
			List<Product> productList = productMapper.selectAllProductList();
			return productList;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public Product selectProductByProductId(Integer productId) {
		try {
			Product product = productMapper.selectProductByProductId(productId);
			System.out.println("selectProductByProductId,productId:" + productId + ",product:" + product);
			return product;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int updateByPrimaryKeySelective(Product product) {
		try {
			int result = productMapper.updateByPrimaryKeySelective(product);
			System.out.println("updateByPrimaryKeySelective,productId:" + product + ",result:" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int deleteProductByProductId(Integer productId) {
		try {
			int result = productMapper.deleteProductByProductId(productId);
			System.out.println("deleteProductByProductId,productId:" + productId + ",result:" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Product> selectProductListByName(String name) {
		try {
			List<Product> productList = productMapper.selectProductListByName(name);
			System.out.println("selectProductListByName,name:" + name + ",productList size:" + productList.size());
			return productList;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

}
