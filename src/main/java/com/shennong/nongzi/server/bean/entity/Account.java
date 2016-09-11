package com.shennong.nongzi.server.bean.entity;

import java.util.Date;

public class Account {
    private Integer accountId;

    private String name;
    
    private Integer customerId;

    private String password;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    private Boolean enable;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", password=" + password + ", type=" + type
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", enable=" + enable + "]";
	}
}