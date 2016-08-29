package com.shennong.nongzi.server.service.sale;

import java.util.List;
import java.util.Map;

import com.shennong.nongzi.common.utils.web.Page;
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
	 * @param page
	 * @return
	 */
	public List<Sale> getSaleListByParam(Map<String, Object> param, Page page);

	/**
	 * 添加销售记录
	 * 
	 * @param sale
	 */
	public void addSale(Sale sale);

	/**
	 * 通过参数获取符合echarts的json字符串(线性图)
	 * 
	 * @see http://echarts.baidu.com/
	 * @param param
	 * @return
	 */
	public String getSaleGeneralOptionByParam(Map<String, Object> param);

	/**
	 * 通过参数获取符合echars的json字符串Map(线型图和饼图)
	 * 
	 * @param param
	 * @return
	 */
	public Map<String, String> getSaleProductOptionByParam(Map<String, Object> param);

	/**
	 * 通过参数获取符合echars的json字符串Map(线型图和饼图)
	 * 
	 * @param param
	 * @return
	 */
	public Map<String, String> getSaleCustomerOptionByParam(Map<String, Object> param);

}
