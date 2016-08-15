package com.shennong.nongzi.server.dal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shennong.nongzi.server.bean.entity.Product;

@MyBatisrepository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

	List<Product> selectAllProductList();

	Product selectProductByProductId(@Param("productId") Integer productId);

	int deleteProductByProductId(@Param("productId") Integer productId);

	List<Product> selectProductListByName(@Param("name") String name);
}