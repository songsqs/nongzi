package com.shennong.nongzi.server.dal.manager;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shennong.nongzi.common.exception.NongziException;
import com.shennong.nongzi.common.utils.RES_STATUS;
import com.shennong.nongzi.server.bean.entity.Sale;
import com.shennong.nongzi.server.dal.dao.SaleMapper;

@Component
public class SaleManager {
	
	private static final Logger logger = LoggerFactory.getLogger(SaleManager.class);

	@Autowired
	private SaleMapper saleMapper;

	public List<Sale> selectSaleListByParam(Map<String, Object> param) {
		try {
			List<Sale> saleList = saleMapper.selectSaleListByParam(param);
			logger.info("selectSaleListByParam,param:" + param + ",size:" + saleList.size());
			return saleList;
		} catch (Exception e) {
			logger.error("selectSaleListByParam", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}

	public int insertSelective(Sale sale) {
		try {
			int result = saleMapper.insert(sale);
			logger.info("insertSelective,sale:" + sale + ",result:" + result);
			return result;
		} catch (Exception e) {
			logger.error("error when insertSelective", e);
			throw new NongziException(RES_STATUS.SERVER_UNKONW_ERROR);
		}
	}
}
