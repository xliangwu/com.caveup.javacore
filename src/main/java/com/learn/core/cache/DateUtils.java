package com.learn.core.cache;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static Date parseDate(String source) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Date ret = null;
		try {
			ret = sf.parse(source);
		} catch (Exception e) {
			return null;
		}
		return ret;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		for (int i = 0; i < 50 * 10000; i++) {
			DateUtils.parseDate("20140228");
		}
		long end = System.currentTimeMillis();
		System.out.println("Use :" + (end - start) + "ms");
	}
}
