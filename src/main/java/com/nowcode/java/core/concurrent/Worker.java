package com.nowcode.java.core.concurrent;

public class Worker extends Thread {

	private BoundedBuffer boundedBuffer;
	private int action;

	public Worker(BoundedBuffer boundedBuffer, int action) {
		this.boundedBuffer = boundedBuffer;
		this.action = action;
	}

	@Override
	public void run() {
		try {
			if (action == 1) {
				// put
				boundedBuffer.put(new Object());
			} else {
				boundedBuffer.take();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
