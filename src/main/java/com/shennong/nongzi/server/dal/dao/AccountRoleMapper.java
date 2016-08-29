package com.shennong.nongzi.server.dal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shennong.nongzi.server.bean.entity.AccountRole;

@MyBatisrepository
public interface AccountRoleMapper {
    int deleteByPrimaryKey(Integer accountRoleId);

    int insert(AccountRole record);

    int insertSelective(AccountRole record);

    AccountRole selectByPrimaryKey(Integer accountRoleId);

    int updateByPrimaryKeySelective(AccountRole record);

    int updateByPrimaryKey(AccountRole record);

	List<AccountRole> selectAccountListByAccountId(@Param("accountId") Integer accountId);
}