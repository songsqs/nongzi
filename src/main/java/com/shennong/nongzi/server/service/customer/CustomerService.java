package com.shennong.nongzi.server.service.customer;

import java.util.List;

import com.shennong.nongzi.server.bean.entity.Customer;

public interface CustomerService {

	/**
	 * 添加客户信息,遇到重复抛出异常
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer);

	/**
	 * 添加客户信息,忽略重复
	 * 
	 * @param customer
	 */
	public void addCustomerIgnoreDuplicate(Customer customer);

	/**
	 * 获取所有客户信息
	 * 
	 * @return
	 */
	public List<Customer> getAllCustomerList();

	/**
	 * 通过客户id获取客户信息
	 * 
	 * @param customerId
	 * @return
	 */
	public Customer getCustomerByCustomerId(Integer customerId);

	/**
	 * 通过客户id更新客户信息
	 * 
	 * @param customer
	 */
	public void updateCustomerByCustomerId(Customer customer);

	/**
	 * 通过客户id删除客户信息
	 * 
	 * @param customerId
	 * @return
	 */
	public int deleteCustomerByCustomerId(Integer customerId);

	/**
	 * 通过客户姓名获取客户信息(like name%)
	 * 
	 * @param name
	 * @return
	 */
	public List<Customer> getCustomerListByName(String name);


}