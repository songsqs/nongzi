package com.shennong.nongzi.server.service.customer;

import java.util.List;
import java.util.Map;

import com.shennong.nongzi.common.utils.web.Page;
import com.shennong.nongzi.server.bean.entity.Customer;
import com.shennong.nongzi.server.bean.entity.CustomerWithAccount;

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
	 * 通过参数获取客户列表
	 * 
	 * @param param
	 * @param page
	 * @return
	 */
	public List<Customer> getCustomerListByParam(Map<String, Object> param, Page page);

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

	/**
	 * 把customer转化为带有帐号相关信息的实例
	 * 
	 * @param customerList
	 * @return
	 */
	public List<CustomerWithAccount> conversionCustomerWithAccount(List<Customer> customerList);


}
