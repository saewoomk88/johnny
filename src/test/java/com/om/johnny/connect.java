package com.om.johnny;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class connect extends AbstractTestCase{
	
	@Inject
	SqlSession sql;

	@Test
	public void test() {
		assertNotNull(sql);
	}

}
