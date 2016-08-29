package com.shennong.nongzi.common.utils.web;

import java.io.Serializable;

/**
 * 用于分页的工具类
 * 
 * @author sqs
 *
 */
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认页大小
	 */
	private static final Integer DEFAULT_PAGE_SIZE = 20;

	/**
	 * 默认页数
	 */
	private static final Integer DEFAULT_PAGE_INDEX = 1;

	/**
	 * 当前页号
	 */
	private Integer pageIndex;

	/**
	 * 当前页大小
	 */
	private Integer pageSize;

	/**
	 * 是否有前一页
	 */
	private Boolean hasPrevious;

	/**
	 * 是否有后一页
	 */
	private Boolean hasNext;

	public Page(Integer pageIndex, Integer pageSize) {
		if (pageIndex <= 0) {
			pageIndex = DEFAULT_PAGE_INDEX;
		}
		if (pageSize <= 0) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Boolean getHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(Boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public Boolean getHasNext() {
		return hasNext;
	}

	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}


}
