package com.shennong.nongzi.server.service.product;

import java.util.List;

import com.shennong.nongzi.server.bean.entity.Product;

/**
 * 产品相关service
 * 
 * @author sqs
 *
 */
public interface ProductService {

	/**
	 * 添加产品,如果遇到重复的抛出异常
	 * 
	 * @param product
	 */
	public void addProduct(Product product);

	/**
	 * 添加产品,忽略重复
	 * 
	 * @param product
	 */
	public void addProductIgnoreDuplicate(Product product);

	/**
	 * 获取所有的产品列表
	 * 
	 * @return
	 */
	public List<Product> getAllProductList();

	/**
	 * 根据产品id获取产品信息
	 * 
	 * @param productId
	 * @return
	 */
	public Product getProductByProductId(Integer productId);

	/**
	 * 根据产品id更新产品信息
	 * 
	 * @param product
	 * @return
	 */
	public Product updateProductByProductId(Product product);

	/**
	 * 根据产品id删除产品
	 * 
	 * @param productId
	 * @return
	 */
	public int deleteProductByProductId(Integer productId);

	/**
	 * 通过产品名字获取产品列表,支持模糊查询(like name%)
	 * 
	 * @return
	 */
	public List<Product> getProductListByName(String name);

}
