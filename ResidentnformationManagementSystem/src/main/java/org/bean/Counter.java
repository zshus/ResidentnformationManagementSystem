package org.bean;

public class Counter {
	
	private static int count=0;
	
	public static int getCount() {
		return ++count;
	}
	
	public static void rollback() {
		count--;
	}

}
