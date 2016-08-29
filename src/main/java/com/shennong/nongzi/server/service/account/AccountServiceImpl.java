package com.shennong.nongzi.server.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.shennong.nongzi.common.constant.ConstantConfig;
import com.shennong.nongzi.server.bean.entity.Account;
import com.shennong.nongzi.server.dal.manager.AccountManager;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountManager accountManager;

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

	public static void main(String[] args) {
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
		String plainPassword = "123456";
		System.out.println(accountServiceImpl.entryptPassword(plainPassword));
		System.out.println(accountServiceImpl.entryptPassword(plainPassword).length());
	}

}
