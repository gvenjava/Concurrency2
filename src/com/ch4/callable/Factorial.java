package com.ch4.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Factorial implements Callable<Integer> {

	private int fac;
	private int result=1;
	public Factorial(int i){
		this.fac = i;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		
		if(fac < 2){
			return fac;
		}else{
			for(int i = 2; i<=fac; i++){
				result *= i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}			
		return result;
	}
}
