package com.Future.demo;

import org.junit.Test;

public class CalculatesPosibleWaysTest {
	
	@Test
	public void testCalculatesPosibleWays() {
		Long n=610L;
		System.out.println("possible ways of "+n+" is "+CalculatesPosibleWays(n));
	}
	
	public Long CalculatesPosibleWays(long n) {
		Long result=(n/7*3)+((n%7)%4)+((n%7)/4)*5+((n%7)/5)+((n%7)/6)*3;
		return result;
	}

}
