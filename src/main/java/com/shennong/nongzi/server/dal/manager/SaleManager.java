package com.shennong.nongzi.server.dal.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Sale;
import com.shennong.nongzi.server.dal.dao.SaleMapper;

@Component
public class SaleManager {
	
	@Autowired
	private SaleMapper saleMapper;

	public List<Sale> selectSaleListByParam(Map<String, Object> param) {
		try {
			List<Sale> saleList = saleMapper.selectSaleListByParam(param);
			System.out.println("selectSaleListByParam,param:" + param + ",size:" + saleList.size());
			return saleList;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int insertSelective(Sale sale) {
		try {
			int result = saleMapper.insert(sale);
			System.out.println("insertSelective,sale:" + sale + ",result:" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}
}
