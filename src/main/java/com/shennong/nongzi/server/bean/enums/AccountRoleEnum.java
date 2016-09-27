package com.shennong.nongzi.server.bean.enums;

public enum AccountRoleEnum {
	ADMIN("admin","admin"),
	MANAGER("manager","manager"),
	NORMAL("normal","normal")
	;

	private final String role;
	private final String desc;

	private AccountRoleEnum(String role, String desc) {
		this.role = role;
		this.desc = desc;
	}

	public String getRole() {
		return role;
	}

	public String getDesc() {
		return desc;
	}

}
