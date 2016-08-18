package com.shennong.nongzi.server.service.account;

import java.util.List;

import com.shennong.nongzi.server.bean.entity.AccountRole;

/**
 * 
 * @author sqs
 *
 */
public interface AccountRoleService {

	/**
	 * 通过用户id获取用户角色列表
	 * 
	 * @param accountId
	 * @return
	 */
	public List<AccountRole> getAccountRoleListByAccountId(Integer accountId);

}
