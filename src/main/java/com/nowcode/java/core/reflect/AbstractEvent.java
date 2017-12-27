package com.nowcode.java.core.reflect;

public abstract class AbstractEvent implements Event {

	protected String name;

	public AbstractEvent(String name) {
		this.name = name;
	}
}
