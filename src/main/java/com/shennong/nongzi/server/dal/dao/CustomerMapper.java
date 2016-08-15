package com.shennong.nongzi.server.dal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shennong.nongzi.server.bean.entity.Customer;

@MyBatisrepository
public interface CustomerMapper {
	int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

	Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

	List<Customer> selectAllCustomerList();

	Customer selectCustomerByCustomerId(@Param("customerId") Integer customerId);

	int deleteCustomerByCustomerId(@Param("customerId") Integer customerId);

	List<Customer> selectCustomerListByName(@Param("name") String name);
}