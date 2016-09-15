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
	
	/**
	 * 为客户创建账户
	 * @param customerId
	 * @return
	 */
	public Account createCustomerAccount(Integer customerId);

	/**
	 * 更改密码
	 * 
	 * @param accountId
	 * @param originPassword
	 * @param newPassword
	 * @return
	 */
	public boolean changePassword(Integer accountId, String originPassword, String newPassword);

	/**
	 * 重置密码
	 * 
	 * @param customerId
	 */
	public void resetPasswordByCustomerId(Integer customerId);

}
