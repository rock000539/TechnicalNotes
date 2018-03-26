package com.Future.demo.util;


public class SingletonSample {
	
	private SingletonSample() {}
	
	private static class SingletonHandle{
		private static SingletonSample singleton = new SingletonSample();
	}
	
	public static SingletonSample getInstance(){
		return SingletonHandle.singleton;
	}

}
