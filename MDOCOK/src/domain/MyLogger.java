package domain;

import java.util.Date;

public class MyLogger {

	private long timeBefore;
	
	public void logDeletePhone() {
		System.out.println("[AOP - Message] : Phone has been delete ");
	}

	public void beforeLog(){
		timeBefore = new Date().getTime();
	}
	
	public void afterLog(){
		long now = new Date().getTime();
		long result = now - timeBefore;
		System.out.println("[AOP - Message] : getContact() took "+result+" ms");
	}
} 