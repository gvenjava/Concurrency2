package com.ch4.example;

public class PrimeNumber {

	private int primeNumber;

	public PrimeNumber(int i){
		this.primeNumber = i;
	}
	
	public int getPrimeNumber() {
		return primeNumber;
	}

	public void setPrimeNumber(int primeNumber) {
		this.primeNumber = primeNumber;
	}

	@Override
	public String toString() {
		return  String.valueOf(primeNumber);
	}
	
	
	
	
	
}
