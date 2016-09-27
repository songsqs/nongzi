package com.shennong.nongzi.server.bean.entity;

public class CustomerWithAccount extends Customer {

	private Boolean hasAccount;

	public CustomerWithAccount(Customer origin) {
		super(origin);
	}

	public Boolean getHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(Boolean hasAccount) {
		this.hasAccount = hasAccount;
	}

	@Override
	public String toString() {
		return super.toString() + "CustomerWithAccount [hasAccount=" + hasAccount + "]";
	}

}
