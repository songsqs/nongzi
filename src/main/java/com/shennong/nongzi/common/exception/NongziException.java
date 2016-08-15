package com.shennong.nongzi.common.exception;

import com.shennong.nongzi.common.utils.RES_STATUS;

public class NongziException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1470153254L;

	private int errorCode = RES_STATUS.SERVER_UNKONW_ERROR.code;
	private String errorMsg = RES_STATUS.SERVER_UNKONW_ERROR.msg;

	public NongziException() {
		super();
	}

	public NongziException(int errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public NongziException(RES_STATUS status) {
		super(status.msg);
		this.errorCode = status.code;
		this.errorMsg = status.msg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
