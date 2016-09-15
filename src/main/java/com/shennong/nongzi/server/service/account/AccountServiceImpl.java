package com.shennong.nongzi.server.service.account;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.shennong.nongzi.common.constant.ConstantConfig;
import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Account;
import com.shennong.nongzi.server.bean.entity.AccountRole;
import com.shennong.nongzi.server.bean.entity.Customer;
import com.shennong.nongzi.server.bean.enums.AccountRoleEnum;
import com.shennong.nongzi.server.bean.enums.AccountTypeEnum;
import com.shennong.nongzi.server.dal.manager.AccountManager;
import com.shennong.nongzi.server.dal.manager.AccountRoleManager;
import com.shennong.nongzi.server.dal.manager.CustomerManager;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountManager accountManager;

	@Autowired
	private CustomerManager customerManager;

	@Autowired
	private AccountRoleManager accountRoleManager;

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public Account getAccountByName(String name) {
		Account account = accountManager.selectAccountByName(name);
		return account;
	}

	private String entryptPassword(String plainPassword) {
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), ConstantConfig.SALT.getBytes(),
				ConstantConfig.HASH_INTERATIONS);
		return Encodes.encodeHex(hashPassword);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public Account createCustomerAccount(Integer customerId) {
		Customer customer = customerManager.selectCustomerByCustomerId(customerId);
		if (customer == null || StringUtils.isBlank(customer.getMobile())) {
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}

		Account account = new Account();
		account.setCustomerId(customer.getCustomerId());
		account.setName(customer.getMobile());
		account.setPassword(entryptPassword(customer.getMobile()));
		account.setType(AccountTypeEnum.CUSTOMER.getType());
		account.setEnable(true);

		Date now = new Date();
		account.setCreateTime(now);
		account.setUpdateTime(now);

		Account result = accountManager.insertSelective(account);

		insertAccountRoleForCustomer(account);

		return result;
	}

	/**
	 * 为客户插入角色
	 * 
	 * @param account
	 */
	private void insertAccountRoleForCustomer(Account account) {
		AccountRole accountRole = new AccountRole();
		accountRole.setAccountId(account.getAccountId());
		accountRole.setRoleName(AccountRoleEnum.NORMAL.getRole());
		accountRole.setEnable(true);

		Date now = new Date();
		accountRole.setCreateTime(now);
		accountRole.setUpdateTime(now);

		accountRoleManager.insertSelective(accountRole);
	}

	@Override
	public boolean changePassword(Integer accountId, String originPassword, String newPassword) {
		Account account = accountManager.selectAccountByAccountId(accountId);
		if (account == null) {
			return false;
		}
		String warpOriginPassword=entryptPassword(originPassword);
		if(warpOriginPassword.equals(account.getPassword())==false){
			logger.warn("The origin password is error");
			return false;
		}

		String warpNewPassword = entryptPassword(newPassword);

		account.setPassword(warpNewPassword);
		account.setUpdateTime(new Date());
		account.setEnable(true);

		accountManager.updateByPrimaryKeySelective(account);

		return true;
	}

	@Override
	public void resetPasswordByCustomerId(Integer customerId) {
		Account account = accountManager.selectAccountByCustomerId(customerId);
		if (account == null) {
			throw new NongziException(RES_STATUS.ACCOUNT_NOT_EXITED);
		}

		account.setPassword(entryptPassword(account.getName()));
		account.setEnable(true);
		account.setUpdateTime(new Date());

		accountManager.updateByPrimaryKeySelective(account);
	}

	public static void main(String[] args) {
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
		String plainPassword = "123456";
		System.out.println(accountServiceImpl.entryptPassword(plainPassword));
		System.out.println(accountServiceImpl.entryptPassword(plainPassword).length());
	}


}
