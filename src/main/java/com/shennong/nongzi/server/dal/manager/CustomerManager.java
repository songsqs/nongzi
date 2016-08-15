package com.shennong.nongzi.server.dal.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Customer;
import com.shennong.nongzi.server.dal.dao.CustomerMapper;

@Component
public class CustomerManager {

	@Autowired
	private CustomerMapper customerMapper;

	public Customer insert(Customer customer) {
		try {
			customerMapper.insert(customer);
			System.out.println("insert,customer:" + customer);
			return customer;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Customer> selectAllCustomerList() {
		try {
			List<Customer> customerList = customerMapper.selectAllCustomerList();
			System.out.println("selectAllCustomer,customerList:" + customerList);
			return customerList;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public Customer selectCustomerByCustomerId(Integer customerId) {
		try {
			Customer customer = customerMapper.selectCustomerByCustomerId(customerId);
			System.out.println("selectCustomerByCustomerId,customer:" + customer);
			return customer;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int updateByPrimaryKeySelective(Customer customer) {
		try {
			int result = customerMapper.updateByPrimaryKeySelective(customer);
			System.out.println("updateByPrimaryKeySelective,result:" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int deleteCustomerByCustomerId(Integer customerId) {
		try {
			int result = customerMapper.deleteCustomerByCustomerId(customerId);
			System.out.println("deleteCustomerByCustomerId,customerId:" + customerId + ",result:" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Customer> selectCustomerListByName(String name) {
		try {
			List<Customer> customerList = customerMapper.selectCustomerListByName(name);
			System.out.println("selectCustomerListByName,name:" + name + ",customerList size:" + customerList.size());
			return customerList;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

}
