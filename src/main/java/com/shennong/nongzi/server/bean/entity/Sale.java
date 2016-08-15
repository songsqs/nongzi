package com.shennong.nongzi.server.bean.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Sale {
    private Integer saleId;

    private Integer customerId;

    private String customerName;

    private Integer productId;

    private String productName;

    private BigDecimal price;

    private Integer num;

    private BigDecimal totalPrice;

    private BigDecimal profit;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Date updateTime;

    private Byte enable;

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", productId=" + productId + ", productName=" + productName + ", price=" + price + ", num=" + num
				+ ", totalPrice=" + totalPrice + ", profit=" + profit + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", enable=" + enable + "]";
	}
}