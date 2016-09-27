package com.shennong.nongzi.server.dal.dao;

import java.util.List;

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

	List<Integer> selectCustomerIdListByCustomerIdList(List<Integer> originCustomerIdList);

	Account selectAccountByAccountId(@Param("accountId") Integer accountId);

	Account selectAccountByCustomerId(@Param("customerId") Integer customerId);
}