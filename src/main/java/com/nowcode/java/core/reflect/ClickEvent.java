package com.nowcode.java.core.reflect;

public class ClickEvent extends AbstractEvent {

	private String eventType;
	protected String clickTime;

	public ClickEvent(String name) {
		super(name);
	}

	public void handle(Event event) {
		checkEvent();
		System.out.println("Process event : " + event.toString());
	}

	public String getEventType() {
		return eventType;
	}

	public static void handleClickEvent(Event event) {

		System.out.println("Process event : " + event.toString());
	}

	private void checkEvent() {

	}

	protected void isValid() {

	}

	public String getClickTime() {
		return clickTime;
	}

	public void setClickTime(String clickTime) {
		this.clickTime = clickTime;
	}
}
