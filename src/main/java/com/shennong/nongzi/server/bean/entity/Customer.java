package com.shennong.nongzi.server.bean.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
	private Integer customerId;

    private String name;

    private String idNo;

    private String mobile;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String province;

    private String city;

    private String district;

    private String village;

    private Date createTime;

    private Date updateTime;

    private Byte enable;

	public Customer() {

	}

	public Customer(Customer origin) {
		this.customerId = origin.customerId;
		this.name = origin.name;
		this.mobile = origin.mobile;
		this.birthday = origin.birthday;
		this.province = origin.province;
		this.city = origin.city;
		this.district = origin.district;
		this.village = origin.village;
		this.createTime = origin.createTime;
		this.updateTime = origin.updateTime;
		this.enable = origin.enable;
	}

	public Integer getCustomerId() {
		return customerId;
    }

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
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
		return "Customer [customerId=" + customerId + ", name=" + name + ", idNo=" + idNo + ", mobile=" + mobile
				+ ", birthday=" + birthday + ", province=" + province + ", city=" + city + ", district=" + district
				+ ", village=" + village + ", createTime=" + createTime + ", updateTime=" + updateTime + ", enable="
				+ enable + "]";
	}
}