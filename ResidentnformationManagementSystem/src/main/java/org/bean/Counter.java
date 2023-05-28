package org.bean;

import kr.ac.green.dao.ResidentDAO;
import kr.ac.green.dao.SqlResidentDao;

public class Counter {
	
	private static int count=0;
	
	public static int getCount() {
		return ++count;
	}
	
	public static void rollback() {
		count--;
	}

}
