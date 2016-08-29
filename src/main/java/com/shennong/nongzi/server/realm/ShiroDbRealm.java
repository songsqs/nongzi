package com.shennong.nongzi.server.realm;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.constant.ConstantConfig;
import com.shennong.nongzi.server.bean.entity.Account;
import com.shennong.nongzi.server.bean.entity.AccountRole;
import com.shennong.nongzi.server.bean.entity.ShiroUser;
import com.shennong.nongzi.server.service.account.AccountRoleService;
import com.shennong.nongzi.server.service.account.AccountService;

@Component
public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountRoleService accountRoleService;

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		List<AccountRole> accountRoleList = accountRoleService.getAccountRoleListByAccountId(shiroUser.getId());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (AccountRole accountRoleT : accountRoleList) {
			info.addRole(accountRoleT.getRoleName());
		}
		return info;
	}

	/**
	 * 认证回掉函数,登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("doGetAuthenticationInfo,token:" + token);

		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

		Account account = accountService.getAccountByName(usernamePasswordToken.getUsername());
		if (account != null) {
			// 若用户存在,将此用户存放到认证info中
			return new SimpleAuthenticationInfo(
					new ShiroUser(account.getAccountId(), account.getName(), account.getType()), account.getPassword(),
					ByteSource.Util.bytes(ConstantConfig.SALT), getName());
		}
		return null;
	}

	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		matcher.setHashAlgorithmName(ConstantConfig.HASH_ALGORITHM);
		matcher.setHashIterations(ConstantConfig.HASH_INTERATIONS);

		setCredentialsMatcher(matcher);
	}

}
