package com.learn.core.concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.learn.core.concurrent.BoundedBuffer;
import com.learn.core.concurrent.Worker;

public class WorkerTest {

	@Test
	public void test1() {
		System.out.println("WORKER TEST");

		ExecutorService service = Executors.newFixedThreadPool(2);
		BoundedBuffer boundedBuffer = new BoundedBuffer();
		for (int i = 0; i < 2; i++) {
			service.submit(new Worker(boundedBuffer, i % 2));
		}

	}
}
