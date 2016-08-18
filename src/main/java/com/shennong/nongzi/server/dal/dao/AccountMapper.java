package com.shennong.nongzi.server.dal.dao;

import org.apache.ibatis.annotations.Param;

import com.shennong.nongzi.server.bean.entity.Account;

@MyBatisrepository
public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

	Account selectAccoutByName(@Param("name") String name);
}