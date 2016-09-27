package com.shennong.nongzi.server.service.sale;

import java.util.List;
import java.util.Map;

import org.apache.activemq.filter.function.makeListFunction;

import com.shennong.nongzi.common.utils.web.Page;
import com.shennong.nongzi.server.bean.entity.Sale;

/**
 * 閿�鍞儏鍐祍ervice
 * 
 * @author sqs
 *
 */
public interface SaleService {

	/**
	 * 閫氳繃鍙傛暟闆嗗悎鑾峰彇閿�鍞垪琛�
	 * 
	 * @param param
	 * @param page
	 * @return
	 */
	public List<Sale> getSaleListByParam(Map<String, Object> param, Page page);

	/**
	 * 娣诲姞閿�鍞褰�
	 * 
	 * @param sale
	 */
	public void addSale(Sale sale);

	/**
	 * 閫氳繃鍙傛暟鑾峰彇绗﹀悎echarts鐨刯son瀛楃涓�(绾挎�у浘)
	 * 
	 * @see http://echarts.baidu.com/
	 * @param param
	 * @return
	 */
	public String getSaleGeneralOptionByParam(Map<String, Object> param);

	/**
	 * 閫氳繃鍙傛暟鑾峰彇绗﹀悎echars鐨刯son瀛楃涓睲ap(绾垮瀷鍥惧拰楗煎浘)
	 * 
	 * @param param
	 * @return
	 */
	public Map<String, String> getSaleProductOptionByParam(Map<String, Object> param);

	/**
	 * 閫氳繃鍙傛暟鑾峰彇绗﹀悎echars鐨刯son瀛楃涓睲ap(绾垮瀷鍥惧拰楗煎浘)
	 * 
	 * @param param
	 * @return
	 */
	public Map<String, String> getSaleCustomerOptionByParam(Map<String, Object> param);
	
	/**
	 * 返回客户购买情况的option
	 * @param param
	 * @param isAdmin 是否时管理员
	 * @return
	 */
	public Map<String, String> getSaleCustomerOptionByParam(Map<String, Object> param,boolean isAdmin);

	/**
	 * delete sale by saleId
	 * 
	 * @param saleId
	 * @return
	 */
	public int deleteSaleBySaleId(Integer saleId);

}
