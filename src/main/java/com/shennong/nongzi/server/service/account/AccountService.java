package com.shennong.nongzi.server.service.account;

import com.shennong.nongzi.server.bean.entity.Account;

/**
 * 
 * @author sqs
 *
 */
public interface AccountService {

	/**
	 * 通过用户名获取用户信息
	 * 
	 * @param name
	 * @return
	 */
	public Account getAccountByName(String name);

}
