package com.ch4.callable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	private String schemaName;
	private String password;
	
	public UserValidator(String schema,String pwd){
		this.schemaName = schema;
		this.password = pwd;
	}
	
	public String getPassword() {
		return password;
	}

	public String getSchemaName() {
		return schemaName;
	}
	
	public boolean validate(){
		
		Random rnd = new Random();		
		int timeout = 1 + rnd.nextInt(5);
		boolean result = rnd.nextBoolean();
		System.out.printf("Schema Type : %s, Will sleep for %d, Result = %b%n",this.schemaName,timeout,result);
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			result = false;
		}
		return result;
	}	
}
