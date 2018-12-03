package com.msa.jbk.dao.impl;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(AccountDaoImplTest.class);
		suite.addTestSuite(OrderDaoImplTest.class);
		//$JUnit-END$
		return suite;
	}

}
