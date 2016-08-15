package com.shennong.nongzi.server.dal.dao;

import com.shennong.nongzi.server.bean.entity.TestEntry;

/**
 * 
 * @author sqs
 *
 */
@MyBatisrepository
public interface TestDao {

	public TestEntry getTestInfo();

}
