package com.shennong.nongzi.common.utils;

public enum RES_STATUS {
	SERVER_UNKONW_ERROR(500, "服务器开小差了"),

	// product
	PRODUCT_ADDED(100001, "此产品已经存在"),
	PRODUCT_NOT_EXITED(100002, "此产品不存在"),
	
	//customer
	CUSTOMER_ADDED(100011,"已经添加此客户"),
	CUSTOMER_NOT_EXITED(100012,"此客户不存在"),
	;
	public final int code;
	public final String msg;

	private RES_STATUS(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
