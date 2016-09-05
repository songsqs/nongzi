package com.shennong.nongzi.server.service.sale;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.Toolbox;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.shennong.nongzi.common.utils.Pair;
import com.shennong.nongzi.common.utils.web.Page;
import com.shennong.nongzi.server.bean.entity.Sale;
import com.shennong.nongzi.server.dal.manager.SaleManager;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleManager saleManager;

	@Override
	public List<Sale> getSaleListByParam(Map<String, Object> param, Page page) {

		Integer pageIndex = page.getPageIndex();
		Integer pageSize = page.getPageSize();

		// page已经保证pageIndex>=1
		Integer begin = (pageIndex - 1) * pageSize;
		// limit=pageSize+1用于确定是否有下一页
		Integer limit = pageSize + 1;

		List<Sale> saleList = saleManager.selectSaleListByParamWithLimit(param, begin, limit);

		boolean isEmpty = CollectionUtils.isEmpty(saleList);

		if (isEmpty || pageIndex <= 1) {
			page.setHasPrevious(Boolean.FALSE);
		} else {
			page.setHasPrevious(Boolean.TRUE);
		}

		if (isEmpty || saleList.size() <= pageSize) {
			page.setHasNext(Boolean.FALSE);
		} else {
			saleList.remove(saleList.size() - 1);
			page.setHasNext(Boolean.TRUE);
		}

		return saleList;
	}

	@Override
	public void addSale(Sale sale) {
		sale.setEnable((byte) 1);
		sale.setUpdateTime(new Date());

		saleManager.insertSelective(sale);
	}

	@Override
	public String getSaleGeneralOptionByParam(Map<String, Object> param) {
		List<Sale> saleList = saleManager.selectSaleListByParam(param);

		return generateSaleGeneralLineOption(saleList);
	}

	/**
	 * 通过销售列表获取销售总额和利润曲线json字符串
	 * 
	 * @param saleList
	 * @return
	 */
	private String generateSaleGeneralLineOption(List<Sale> saleList) {
		Map<String, BigDecimal> profitMap = getProfitMapBySaleList(saleList);
		List<String> dayTimeList = new ArrayList<>(profitMap.keySet());
		Collections.sort(dayTimeList);

		// 构造option
		Option option = new Option();
		// 标题
		option.title(new Title().text("销售曲线图").x(X.left));
		// 图例
		option.legend(new Legend().data("利润", "总额"));
		// 工具栏
		option.toolbox(new Toolbox().show(true).feature(Feature.dataZoom, Feature.dataView, Feature.magicType,
				Feature.restore, Feature.saveAsImage));
		// tooltip
		option.tooltip(new Tooltip().trigger(Trigger.axis));
		// x轴
		option.xAxis(new CategoryAxis().boundaryGap(true).data(dayTimeList.toArray()));
		// y轴
		option.yAxis(new ValueAxis().axisLabel(new AxisLabel().formatter("{value} 元")));

		Line profitLine = new Line();
		profitLine.name("利润");
		profitLine.markPoint(new MarkPoint().data(new Data().type(MarkType.max).name("最大值"),
				new Data().type(MarkType.min).name("最小值")));
		profitLine.markLine(new MarkLine().data(new Data().type(MarkType.average).name("平均值")));
		for (String dayTimeT : dayTimeList) {
			profitLine.data(String.format("%.2f", profitMap.get(dayTimeT)));
		}
		option.series(profitLine);

		Map<String, BigDecimal> totalPriceMap = getTotalPriceMapBySaleList(saleList);

		Line totalPriceLine = new Line();
		totalPriceLine.name("总额");
		totalPriceLine.markPoint(new MarkPoint().data(new Data().type(MarkType.max).name("最大值"),
				new Data().type(MarkType.min).name("最小值")));
		totalPriceLine.markLine(new MarkLine().data(new Data().type(MarkType.average).name("平均值")));
		for (String dayTimeT : dayTimeList) {
			totalPriceLine.data(String.format("%.2f", totalPriceMap.get(dayTimeT)));
		}
		option.series(totalPriceLine);

		return JSONObject.toJSONString(option);
	}

	/**
	 * 把列表封装进Map,以日期(精确到天)为key,利润为value
	 * 
	 * @param saleList
	 * @return
	 */
	private Map<String, BigDecimal> getProfitMapBySaleList(List<Sale> saleList) {
		if (CollectionUtils.isEmpty(saleList)) {
			return new HashMap<>();
		}

		Map<String, BigDecimal> result = new HashMap<>();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

		for (Sale saleT : saleList) {
			if (saleT.getCreateTime() == null || saleT.getProfit() == null) {
				continue;
			}

			String dayTime = formater.format(saleT.getCreateTime());
			BigDecimal profit = result.get(dayTime);
			if (profit == null) {
				profit = new BigDecimal(saleT.getProfit().doubleValue());
				result.put(dayTime, profit);
			} else {
				result.put(dayTime, profit.add(saleT.getProfit()));
			}

		}

		return result;
	}

	/**
	 * 把列表封装进Map,以日期(精确到天)为key,销售量为value
	 * 
	 * @param saleList
	 * @return
	 */
	private Map<String, BigDecimal> getTotalPriceMapBySaleList(List<Sale> saleList) {
		if (CollectionUtils.isEmpty(saleList)) {
			new HashMap<>();
		}
		Map<String, BigDecimal> result = new HashMap<>();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

		for (Sale saleT : saleList) {
			if (saleT.getCreateTime() == null || saleT.getTotalPrice() == null) {
				continue;
			}

			String dayTime = formater.format(saleT.getCreateTime());
			BigDecimal totalPrice = result.get(dayTime);
			if (totalPrice == null) {
				totalPrice = new BigDecimal(saleT.getTotalPrice().doubleValue());
				result.put(dayTime, totalPrice);
			} else {
				result.put(dayTime, totalPrice.add(saleT.getTotalPrice()));
			}
		}

		return result;
	}

	@Override
	public Map<String, String> getSaleProductOptionByParam(Map<String, Object> param) {
		List<Sale> saleList = saleManager.selectSaleListByParam(param);

		Map<String, String> result = new HashMap<>();

		result.put("productLineOption", generateSaleGeneralLineOption(saleList));
		result.put("productPieOption", generateProductSaleNumGroupByCustomerPieOption(saleList));

		return result;
	}

	/**
	 * 把列表封装进Map,以客户姓名为key,客户购买产品数量为value
	 * 
	 * @param saleList
	 * @return
	 */
	private Map<Pair<Integer, String>, Integer> getProductSaleNumMapGroupByCustomer(List<Sale> saleList) {
		if (CollectionUtils.isEmpty(saleList)) {
			return new HashMap<>();
		}

		Map<Pair<Integer, String>, Integer> result = new HashMap<>();
		for (Sale saleT : saleList) {
			if (saleT.getCustomerId() == null || saleT.getCustomerName() == null || saleT.getNum() == null) {
				continue;
			}
			// 为防止出现客户重名的情况,把客户id和姓名一同作为key,这样可以少读一遍数据库
			Pair<Integer, String> pair = new Pair<Integer, String>(saleT.getCustomerId(), saleT.getCustomerName());
			Integer num = result.get(pair);
			if (num == null) {
				num = 0;
			}
			num += saleT.getNum();
			result.put(pair, num);
		}

		return result;
	}

	/**
	 * 通过销售列表获取echarts饼形图json字符串(客户维度)
	 * 
	 * @param saleList
	 * @return
	 */
	// TODO 加入最多只能显示特定数量的客户,多的客户以其他显示
	private String generateProductSaleNumGroupByCustomerPieOption(List<Sale> saleList) {
		Map<Pair<Integer, String>, Integer> productSaleNumMap = getProductSaleNumMapGroupByCustomer(saleList);
		List<String> customerNameList = new ArrayList<>();
		for (Pair<Integer, String> pairT : productSaleNumMap.keySet()) {
			customerNameList.add(pairT.getSecond());
		}

		Option option = new Option();
		// title
		option.title(
				new Title().text("客户购买量分布").x(X.center).subtext("产品:" + generateProductNameListBySaleList(saleList)));
		// tooltip
		option.tooltip(new Tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)"));
		// 图例
		option.legend(new Legend().orient(Orient.vertical).left(X.left).data(customerNameList));

		// 饼形图
		Pie pie = new Pie();
		pie.name("购买量");
		pie.radius("55%").center("50%", "60%");
		pie.itemStyle(new ItemStyle()
				.emphasis(new Emphasis().shadowBlur(10).shadowOffsetX(0).shadowColor("rgba(0, 0, 0, 0.5)")));
		// 加载数据
		for (Pair<Integer, String> pairT : productSaleNumMap.keySet()) {
			pie.data(new Data(pairT.getSecond(), productSaleNumMap.get(pairT)));
		}

		option.series(pie);

		return JSONObject.toJSONString(option);
	}

	@Override
	public Map<String, String> getSaleCustomerOptionByParam(Map<String, Object> param) {
		Map<String, String> result = new HashMap<>();

		List<Sale> saleList = saleManager.selectSaleListByParam(param);

		result.put("customerLineOption", generateSaleGeneralLineOption(saleList));
		result.put("customerPieOption", generateCustomerSaleNumGroupByProductPieOption(saleList));

		return result;
	}

	/**
	 * 通过销售列表获取echarts饼形图json(产品维度)
	 * 
	 * @param saleList
	 * @return
	 */
	private String generateCustomerSaleNumGroupByProductPieOption(List<Sale> saleList) {
		Map<Pair<Integer, String>, Integer> customerSaleNumMap = getCustomerSaleNumMapGroupByProduct(saleList);
		List<String> productNameList = new ArrayList<>();
		for (Pair<Integer, String> pairT : customerSaleNumMap.keySet()) {
			productNameList.add(pairT.getSecond());
		}

		Option option = new Option();
		// title
		option.title(
				new Title().text("产品购买量分布").x(X.center).subtext("客户:" + generateCustomerNameListBySaleList(saleList)));
		// tooltip
		option.tooltip(new Tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)"));
		// 图例
		option.legend(new Legend().orient(Orient.vertical).left(X.left).data(productNameList));

		// 饼形图
		Pie pie = new Pie();
		pie.name("购买量");
		pie.radius("55%").center("50%", "60%");
		pie.itemStyle(new ItemStyle()
				.emphasis(new Emphasis().shadowBlur(10).shadowOffsetX(0).shadowColor("rgba(0, 0, 0, 0.5)")));
		// 加载数据
		for (Pair<Integer, String> pairT : customerSaleNumMap.keySet()) {
			pie.data(new Data(pairT.getSecond(), customerSaleNumMap.get(pairT)));
		}

		option.series(pie);

		return JSONObject.toJSONString(option);
	}

	/**
	 * 把列表封装进map,以产品信息为key,购买数量为value
	 * 
	 * @param saleList
	 * @return
	 */
	private Map<Pair<Integer, String>, Integer> getCustomerSaleNumMapGroupByProduct(List<Sale> saleList) {
		if (CollectionUtils.isEmpty(saleList)) {
			return new HashMap<>();
		}

		Map<Pair<Integer, String>, Integer> result = new HashMap<>();
		for (Sale saleT : saleList) {
			if (saleT.getProductId() == null || saleT.getProductName() == null || saleT.getNum() == null) {
				continue;
			}

			Pair<Integer, String> pair = new Pair<Integer, String>(saleT.getProductId(), saleT.getProductName());
			Integer num = result.get(pair);
			if (num == null) {
				num = 0;
			}
			num += saleT.getNum();
			result.put(pair, num);
		}

		return result;
	}

	private Set<String> generateCustomerNameListBySaleList(List<Sale> saleList) {
		if (CollectionUtils.isEmpty(saleList)) {
			return new HashSet<>();
		}

		Set<String> result = new HashSet<>();
		for (Sale saleT : saleList) {
			if (saleT.getCustomerName() != null) {
				result.add(saleT.getCustomerName());
			}
		}

		return result;
	}

	public Set<String> generateProductNameListBySaleList(List<Sale> saleList) {
		if (CollectionUtils.isEmpty(saleList)) {
			return new HashSet<>();
		}

		Set<String> result = new HashSet<>();
		for (Sale saleT : saleList) {
			if (saleT.getProductName() != null) {
				result.add(saleT.getProductName());
			}
		}

		return result;
	}

	@Override
	public int deleteSaleBySaleId(Integer saleId) {
		int result = saleManager.deleteSaleBySaleId(saleId);
		return result;
	}

}
