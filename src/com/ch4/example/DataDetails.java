package com.ch4.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


public class DataDetails implements Callable<DataDetails>{

	private int start;
	private int end;
	private List<PrimeNumber> flag;
	
	public DataDetails(int s, int e){
		this.start = s;
		this.end = e;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	public List<PrimeNumber> getFlag() {
		return flag;
	}

	public void setFlag(List<PrimeNumber> flag) {
		this.flag = flag;
	}

	
	
	

	@Override
	public String toString() {
		return "DataDetails start=" + start + ", end=" + end + ", Prime Number ="
				+ flag ;
	}

	@Override
	public DataDetails call() throws Exception {
		// TODO Auto-generated method stub
		
		this.setFlag(new ArrayList<PrimeNumber>());
		for(int i = start; i <=end; i++){
			if(isPrime(i))
				flag.add(new PrimeNumber(i));
//			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("EXECUTING...");
		return this;
	}
	
	private boolean isPrime(int n){		
		for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
    }	
}