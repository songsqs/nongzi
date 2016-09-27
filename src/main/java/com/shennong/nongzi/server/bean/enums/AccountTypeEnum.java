package com.shennong.nongzi.server.bean.enums;

public enum AccountTypeEnum {
	CUSTOMER(0,"客户账户"),
	ADMIN(1,"管理员账户")
	;
	private final int type;
	private final String desc;

	private AccountTypeEnum(int type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public int getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}
}
