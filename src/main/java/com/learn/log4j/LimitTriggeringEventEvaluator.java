package com.learn.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.TriggeringEventEvaluator;

public class LimitTriggeringEventEvaluator implements TriggeringEventEvaluator {

	private volatile long eventAcc = 0;

	public boolean isTriggeringEvent(LoggingEvent event) {
		boolean errorLevel = event.getLevel().isGreaterOrEqual(Level.ERROR);
		if (errorLevel) {
			eventAcc++;
			if (eventAcc > 10) {
				System.out.println("Alert > 10");
				errorLevel = false;
			}
		}
		return errorLevel;
	}

}
