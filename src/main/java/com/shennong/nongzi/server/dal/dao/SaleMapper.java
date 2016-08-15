package com.shennong.nongzi.server.dal.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shennong.nongzi.server.bean.entity.Sale;

@MyBatisrepository
public interface SaleMapper {
    int deleteByPrimaryKey(Integer saleId);

    int insert(Sale record);

    int insertSelective(Sale record);

    Sale selectByPrimaryKey(Integer saleId);

    int updateByPrimaryKeySelective(Sale record);

    int updateByPrimaryKey(Sale record);

	List<Sale> selectSaleListByParam(@Param("param") Map<String, Object> param);

}