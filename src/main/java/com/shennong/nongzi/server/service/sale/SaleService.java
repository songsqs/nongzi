package com.shennong.nongzi.server.service.sale;

import java.util.List;
import java.util.Map;

import com.shennong.nongzi.server.bean.entity.Sale;

/**
 * 销售情况service
 * 
 * @author sqs
 *
 */
public interface SaleService {

	/**
	 * 通过参数集合获取销售列表
	 * 
	 * @param param
	 * @return
	 */
	public List<Sale> getSaleListByParam(Map<String, Object> param);

	/**
	 * 添加销售记录
	 * 
	 * @param sale
	 */
	public void addSale(Sale sale);

}
