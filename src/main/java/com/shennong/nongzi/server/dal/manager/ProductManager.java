package com.shennong.nongzi.server.dal.manager;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Product;
import com.shennong.nongzi.server.dal.dao.ProductMapper;

@Component
public class ProductManager {

	private static final Logger logger = LoggerFactory.getLogger(ProductManager.class);

	@Autowired
	private ProductMapper productMapper;

	public Product insert(Product product) {
		try {
			productMapper.insert(product);
			logger.info("insert product:" + product);
			return product;
		} catch (Exception e) {
			logger.error("error when insert", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Product> getAllProductList() {
		try {
			List<Product> productList = productMapper.selectAllProductList();
			logger.info("getAllProductList,productList:" + productList);
			return productList;
		} catch (Exception e) {
			logger.error("error when getAllProductList", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public Product selectProductByProductId(Integer productId) {
		try {
			Product product = productMapper.selectProductByProductId(productId);
			logger.info("selectProductByProductId,productId:" + productId + ",product:" + product);
			return product;
		} catch (Exception e) {
			logger.error("error when selectProductByProductId", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int updateByPrimaryKeySelective(Product product) {
		try {
			int result = productMapper.updateByPrimaryKeySelective(product);
			logger.info("updateByPrimaryKeySelective,productId:" + product + ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when updateByPrimaryKeySelective", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int deleteProductByProductId(Integer productId) {
		try {
			int result = productMapper.deleteProductByProductId(productId);
			logger.info("deleteProductByProductId,productId:" + productId + ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when deleteProductByProductId", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Product> selectProductListByName(String name) {
		try {
			List<Product> productList = productMapper.selectProductListByName(name);
			logger.info("selectProductListByName,name:" + name + ",productList size:" + productList.size());
			return productList;
		} catch (Exception e) {
			logger.error("error when selectProductListByName", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Product> selectProdyctListByParamWithLimit(Map<String, Object> param, Integer begin, Integer limit) {
		try {
			List<Product> productList = productMapper.selectProductListByParamWithLimit(param, begin, limit);
			logger.info("selectProdyctListByParamWithLimit,param:" + param + ",begin:" + begin + ",limit:" + limit
					+ ",size:" + productList.size());
			return productList;
		} catch (Exception e) {
			logger.error("error when selectProdyctListByParamWithLimit", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

}
