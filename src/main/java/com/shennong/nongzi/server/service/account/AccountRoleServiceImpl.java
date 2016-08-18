package com.shennong.nongzi.server.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shennong.nongzi.server.bean.entity.AccountRole;
import com.shennong.nongzi.server.dal.manager.AccountRoleManager;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {

	@Autowired
	private AccountRoleManager accountRoleManager;

	@Override
	public List<AccountRole> getAccountRoleListByAccountId(Integer accountId) {
		List<AccountRole> accountRoleList = accountRoleManager.selectAccountRoleListByAccountId(accountId);
		return accountRoleList;
	}

}
