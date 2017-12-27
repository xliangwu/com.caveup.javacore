package com.nowcode.java.core.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoundedBuffer {

	private static final Logger LOGGER = LoggerFactory.getLogger(BoundedBuffer.class);

	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];
	int putptr, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		LOGGER.info("PUT GET LOCK");
		try {
			while (count == items.length) {
				LOGGER.info("PUT Will Waiting/" + Thread.currentThread().getName());
				notFull.await();
				LOGGER.info("Waiting Put....");
			}

			LOGGER.info("PUT : " + x.toString() + "/" + Thread.currentThread().getName());
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		LOGGER.info("TAKE GET LOCK");
		try {
			while (count == 0) {
				LOGGER.info("TAKE Will Waiting/" + Thread.currentThread().getName());
				notEmpty.await();
				LOGGER.info("Waiting Take....");
			}

			Object x = items[takeptr];
			LOGGER.info("TAKE : " + x.toString() + "/" + Thread.currentThread().getName());
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}
