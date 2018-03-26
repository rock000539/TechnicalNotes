package com.Future.demo;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.Future.demo.util.SingletonSample;

public class SingletonSampleTest {
	private Logger log = LogManager.getLogger(SingletonSampleTest.class);
	
	@Before
	public void before() {
		log.info("Before test");
	}
	
	@Test
	public void getInstanceTest() {
		log.info("Start test");
		assertEquals(SingletonSample.getInstance(), SingletonSample.getInstance());
	}

}
