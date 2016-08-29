package com.shennong.nongzi.server.dal.manager;

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

}
