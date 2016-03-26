package com.ch4.callable;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {

	private String tName;
	private UserValidator uv;
	
	public TaskValidator(String threadName,UserValidator uv){
		this.tName = threadName;
		this.uv = uv;
	}	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		if(!uv.validate()){
			System.out.printf("Validation Failed for Thread name : %s%n",this.tName);
			throw new Exception("Validation Failed for "+this.tName);
		}		
		return this.uv.getSchemaName();
	}
}
