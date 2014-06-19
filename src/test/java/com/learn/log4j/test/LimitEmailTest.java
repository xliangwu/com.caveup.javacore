package com.learn.log4j.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LimitEmailTest {

	public static final Logger LOGGER = LoggerFactory.getLogger(LimitEmailTest.class);

	@Test
	public void test() {

		for (int i = 0; i < 100; i++) {
			LOGGER.error("Test limit email function");
		}
	}

}
