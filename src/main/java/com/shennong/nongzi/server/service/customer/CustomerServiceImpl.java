package com.shennong.nongzi.server.service.customer;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shennong.nongzi.common.utils.web.Page;
import com.shennong.nongzi.server.bean.entity.Customer;
import com.shennong.nongzi.server.dal.manager.CustomerManager;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerManager customerManager;

	@Override
	public void addCustomer(Customer customer) {
		customer.setEnable((byte) 1);
		Date now = new Date();
		customer.setCreateTime(now);
		customer.setUpdateTime(now);
		customerManager.insert(customer);
	}

	@Override
	public void addCustomerIgnoreDuplicate(Customer customer) {
		customerManager.insert(customer);
	}

	@Override
	public List<Customer> getAllCustomerList() {
		List<Customer> customerList = customerManager.selectAllCustomerList();
		return customerList;
	}

	@Override
	public List<Customer> getCustomerListByParam(Map<String, Object> param, Page page) {

		Integer pageIndex = page.getPageIndex();
		Integer pageSize = page.getPageSize();

		Integer begin = (pageIndex - 1) * pageSize;
		Integer limit = pageSize + 1;

		List<Customer> customerList = customerManager.selectCustomerLIstByParamWithLimit(param, begin, limit);

		boolean isEmpty = CollectionUtils.isEmpty(customerList);

		if (isEmpty || pageIndex <= 1) {
			page.setHasPrevious(Boolean.FALSE);
		} else {
			page.setHasPrevious(Boolean.TRUE);
		}

		if (isEmpty || customerList.size() <= pageSize) {
			page.setHasNext(Boolean.FALSE);
		} else {
			page.setHasNext(Boolean.TRUE);
			customerList.remove(customerList.size() - 1);
		}

		return customerList;
	}

	@Override
	public Customer getCustomerByCustomerId(Integer customerId) {
		Customer customer = customerManager.selectCustomerByCustomerId(customerId);
		return customer;
	}

	@Override
	public void updateCustomerByCustomerId(Customer customer) {
		customer.setEnable((byte) 1);
		customer.setUpdateTime(new Date());

		customerManager.updateByPrimaryKeySelective(customer);
	}

	@Override
	public int deleteCustomerByCustomerId(Integer customerId) {
		int result = customerManager.deleteCustomerByCustomerId(customerId);
		return result;
	}

	@Override
	public List<Customer> getCustomerListByName(String name) {
		List<Customer> customerList = customerManager.selectCustomerListByName(name);
		return customerList;
	}

}
