package com.Future.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

public class FibonacciTest {
	Long testNumber;

	static Map<Long, Long> valueMap = new HashMap<Long, Long>() {
		{
			put(0L, 0L);
			put(1L, 1L);
		}
	};

	@Before
	public void setUp() {
		testNumber = 8181L;
	}

//	@Test
	public void testIterative() {

		long time1, time2, time3;

		time1 = System.currentTimeMillis();
		System.out.println("FibonacciIterative result " + FibonacciIterative(testNumber));
		time2 = System.currentTimeMillis();
		System.out.println("spend time is " + (time2 - time1) + " ms");

		System.out.println("FibonacciIterativeEnhance result " + FibonacciIterativeEnhance(testNumber));
		time3 = System.currentTimeMillis();
		System.out.println("spend time is " + (time3 - time2) + " ms");

	}
	
//	@Test
	public void teseRecursion() {
		
		long time1, time2, time3;

		time1 = System.currentTimeMillis();
		System.out.println("FibonacciRecursion result " + FibonacciRecursion(testNumber));
		time2 = System.currentTimeMillis();
		System.out.println("spend time is " + (time2 - time1) + " ms");

		System.out.println("FibonacciRecursionEnhance result " + FibonacciRecursionEnhance(testNumber));
		time3 = System.currentTimeMillis();
		System.out.println("spend time is " + (time3 - time2) + " ms");
		
	}	
	

	public Long FibonacciIterative(Long testNumber) {
		Long value1 = 0L;
		Long value2 = 1L;
		Long result = testNumber;

		for (int i = 2; i <= testNumber; ++i) {
			result = value2 + value1;
			value1 = value2;
			value2 = result;
		}

		return result;
	}

	public Long FibonacciRecursion(Long testNumber) {

		if (testNumber.equals(0L))
			return 0L;
		if (testNumber.equals(1L))
			return 1L;

		return FibonacciRecursion(testNumber - 1) + FibonacciRecursion(testNumber - 2);
	}

	public Long FibonacciIterativeEnhance(Long testNumber) {

		for (Long i = 2L; i <= testNumber; ++i)
			valueMap.put(i, valueMap.get(i - 1) + valueMap.get(i - 2));

		return valueMap.get(testNumber);
	}

	public Long FibonacciRecursionEnhance(Long testNumber) {

		if (testNumber.equals(0L))
			return 0L;
		if (testNumber.equals(1L))
			return 1L;

		Long result = FibonacciRecursion(testNumber - 1) + FibonacciRecursion(testNumber - 2);

		valueMap.put(testNumber, result);

		return result;
	}
	


}
