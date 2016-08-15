package com.shennong.nongzi.server.bean.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer productId;

    private String name;

    private String manufacturer;

    private BigDecimal price;

    private BigDecimal priceLower;

    private Date createTime;

    private Date updateTime;

    private Byte enable;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceLower() {
        return priceLower;
    }

    public void setPriceLower(BigDecimal priceLower) {
        this.priceLower = priceLower;
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
		return "Product [productId=" + productId + ", name=" + name + ", manufacturer=" + manufacturer + ", price="
				+ price + ", priceLower=" + priceLower + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", enable=" + enable + "]";
	}
}