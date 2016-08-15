package com.shennong.nongzi.common.utils;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	/**
	 * 获取src的正确值,如果src为null或者为空字符串,返回null
	 * 
	 * @param src
	 * @return
	 */
	public static String realString(String src) {
		if (StringUtils.isEmpty(src)) {
			return null;
		}
		return src;
	}

}
