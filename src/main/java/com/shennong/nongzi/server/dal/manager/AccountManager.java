package com.shennong.nongzi.server.dal.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Account;
import com.shennong.nongzi.server.dal.dao.AccountMapper;

@Component
public class AccountManager {

	private static Logger logger = LoggerFactory.getLogger(AccountManager.class);

	@Autowired
	private AccountMapper accountMapper;

	public Account selectAccountByName(String name) {
		try {
			Account account = accountMapper.selectAccoutByName(name);
			logger.info("selectAccountByName,name" + name);
			return account;
		} catch (Exception e) {
			logger.error("error when selectAccountByName", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public Account insertSelective(Account account) {
		try {
			int result = accountMapper.insertSelective(account);
			logger.info("insertSelective,account:" + account + ",result:" + result);
			return account;
		} catch (Exception e) {
			logger.error("error when insertSelective", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public List<Integer> selectCustomerIdListByCustomerIdList(List<Integer> originCustomerIdList) {
		try {
			List<Integer> customerIdList = accountMapper.selectCustomerIdListByCustomerIdList(originCustomerIdList);
			logger.info("selectCustomerIdListByCustomerIdList,origin:" + originCustomerIdList + ",result:"
					+ customerIdList);
			return customerIdList;
		} catch (Exception e) {
			logger.error("error when selectCustomerIdListByCustomerIdList", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public Account selectAccountByAccountId(Integer accountId) {
		try {
			Account account = accountMapper.selectAccountByAccountId(accountId);
			logger.info("selectAccountByAccountId,result:" + account);
			return account;
		} catch (Exception e) {
			logger.error("error when selectAccountByAccountId", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int updateByPrimaryKeySelective(Account account) {
		try {
			int result = accountMapper.updateByPrimaryKeySelective(account);
			logger.info("updateByPrimaryKeySelective,account:" + account + ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when updateByPrimaryKeySelective", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public Account selectAccountByCustomerId(Integer customerId) {
		try {
			Account account = accountMapper.selectAccountByCustomerId(customerId);
			logger.info("selectAccountByCustomerId,customerId:" + customerId + ",result:" + account);
			return account;
		} catch (Exception e) {
			logger.error("error when selectAccountByCustomerId", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

}
