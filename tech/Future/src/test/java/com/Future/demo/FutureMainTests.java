package com.Future.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Future.demo.task.RealData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FutureMainTests {

//	@Test
	public void newFixedThreadPoolTest() throws InterruptedException, ExecutionException {
		FutureTask<String> future = new FutureTask<String>(new RealData("a"));
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
		fixedThreadPool.submit(future);
		// Future<String> future = executor.submit(new RealData("a"));
		System.out.println("Request finish");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("Data = " + future.get());
	}

	 @Test
	public void scheduledThreadPoolTest() throws InterruptedException {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("delay 3 seconds");
			}

		}, 3, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

	// @Test
	public void scheduleAtFixedRateTest() throws InterruptedException {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}

		}, 1, 3, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

}
