package com.shennong.nongzi.server.dal.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.AccountRole;
import com.shennong.nongzi.server.dal.dao.AccountRoleMapper;

@Component
public class AccountRoleManager {

	private static Logger logger = LoggerFactory.getLogger(AccountRoleManager.class);

	@Autowired
	private AccountRoleMapper accountRoleMapper;

	public List<AccountRole> selectAccountRoleListByAccountId(Integer accountId) {
		try {
			List<AccountRole> accountRoleList = accountRoleMapper.selectAccountListByAccountId(accountId);
			logger.info(
					"selectAccountRoleListByAccountId,accountId:" + accountId + ",accountRoleList " + accountRoleList);
			return accountRoleList;
		} catch (Exception e) {
			logger.error("error when selectAccountRoleListByAccountId", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public AccountRole insertSelective(AccountRole accountRole) {
		try {
			int result = accountRoleMapper.insertSelective(accountRole);
			logger.info("insertSelective,accountRole:" + accountRole + ",result:" + result);
			return accountRole;
		} catch (Exception e) {
			logger.error("error when insertSelective", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}
}
