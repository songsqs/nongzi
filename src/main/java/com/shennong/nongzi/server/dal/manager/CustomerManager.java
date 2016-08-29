package com.shennong.nongzi.server.dal.manager;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Customer;
import com.shennong.nongzi.server.dal.dao.CustomerMapper;

@Component
public class CustomerManager {

	private static final Logger logger = LoggerFactory.getLogger(CustomerManager.class);

	@Autowired
	private CustomerMapper customerMapper;

	public Customer insert(Customer customer) {
		try {
			customerMapper.insert(customer);
			logger.info("insert,customer:" + customer);
			return customer;
		} catch (Exception e) {
			logger.error("error when insert customer", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Customer> selectAllCustomerList() {
		try {
			List<Customer> customerList = customerMapper.selectAllCustomerList();
			logger.info("selectAllCustomer,customerList:" + customerList);
			return customerList;
		} catch (Exception e) {
			logger.error("error when selectAllCustomerList", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public Customer selectCustomerByCustomerId(Integer customerId) {
		try {
			Customer customer = customerMapper.selectCustomerByCustomerId(customerId);
			logger.info("selectCustomerByCustomerId,customer:" + customer);
			return customer;
		} catch (Exception e) {
			logger.error("error when selectCustomerByCustomerId", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int updateByPrimaryKeySelective(Customer customer) {
		try {
			int result = customerMapper.updateByPrimaryKeySelective(customer);
			logger.info("updateByPrimaryKeySelective,result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when updateByPrimaryKeySelective", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int deleteCustomerByCustomerId(Integer customerId) {
		try {
			int result = customerMapper.deleteCustomerByCustomerId(customerId);
			logger.info("deleteCustomerByCustomerId,customerId:" + customerId + ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when deleteCustomerByCustomerId", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Customer> selectCustomerListByName(String name) {
		try {
			List<Customer> customerList = customerMapper.selectCustomerListByName(name);
			logger.info("selectCustomerListByName,name:" + name + ",customerList size:" + customerList.size());
			return customerList;
		} catch (Exception e) {
			logger.error("error when selectCustomerListByName", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Customer> selectCustomerLIstByParamWithLimit(Map<String, Object> param, Integer begin, Integer limit) {
		try {
			List<Customer> customerList = customerMapper.selectCustomerListByParamWithLimit(param, begin, limit);
			logger.info("selectCustomerLIstByParamWithLimit,param:" + param + ",begin:" + begin + ",limit:" + limit
					+ ",size:" + customerList.size());
			return customerList;
		} catch (Exception e) {
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

}
