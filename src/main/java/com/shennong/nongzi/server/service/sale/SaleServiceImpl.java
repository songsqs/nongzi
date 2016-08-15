package com.shennong.nongzi.server.service.sale;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shennong.nongzi.server.bean.entity.Sale;
import com.shennong.nongzi.server.dal.manager.SaleManager;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleManager saleManager;

	@Override
	public List<Sale> getSaleListByParam(Map<String, Object> param) {
		List<Sale> saleList = saleManager.selectSaleListByParam(param);
		return saleList;
	}

	@Override
	public void addSale(Sale sale) {
		sale.setEnable((byte) 1);
		sale.setUpdateTime(new Date());

		saleManager.insertSelective(sale);
	}

}
