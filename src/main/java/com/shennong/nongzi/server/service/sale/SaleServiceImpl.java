package com.shennong.nongzi.server.service.sale;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
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

	@Override
	public String getSaleGeneralOptionByParam(Map<String, Object> param) {
		List<Sale> saleList = saleManager.selectSaleListByParam(param);

		Map<String, BigDecimal> profitMap = getProfitMapByParam(saleList);

		// 构造option
		Option option = new Option();
		// 标题
		option.title(new Title().text("销售曲线图").x(X.left));
		// 图例
		option.legend(new Legend().data("利润"));
		// 工具栏
		option.toolbox(new Toolbox().show(true).feature(Feature.dataZoom, Feature.dataView, Feature.magicType,
				Feature.restore, Feature.saveAsImage));
		// tooltip
		option.tooltip(new Tooltip().trigger(Trigger.axis));
		// x轴
		List<String> dayTimeList = new ArrayList<>(profitMap.keySet());
		option.xAxis(new CategoryAxis().boundaryGap(false).data(dayTimeList.toArray()));
		// y轴
		option.yAxis(new ValueAxis().axisLabel(new AxisLabel().formatter("{value} 元")));

		Line profitLine = new Line();
		profitLine.name("利润");
		profitLine.markPoint(new MarkPoint().data(new Data().type(MarkType.max).name("最大值"),
				new Data().type(MarkType.min).name("最小值")));
		profitLine.markLine(new MarkLine().data(new Data().type(MarkType.average).name("平均值")));
		for (String datTimeT : dayTimeList) {
			profitLine.data(profitMap.get(datTimeT));
		}

		option.series(profitLine);

		return JSONObject.toJSONString(option);
	}

	/**
	 * 把列表封装进Map,以日期(精确到天)为key,利润为value
	 * 
	 * @param saleList
	 * @return
	 */
	private Map<String, BigDecimal> getProfitMapByParam(List<Sale> saleList) {
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
				profit.add(saleT.getProfit());
			}

		}

		return result;
	}

}
