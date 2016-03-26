package com.ch3.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class MainExchanger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> producer = new ArrayList<>();
		List<String> consumer = new ArrayList<>();
		Exchanger<List<String>> exchanger = new Exchanger<>();
		
		Thread prod = new Thread(new Producer(producer,exchanger),"Producer");
		Thread cons = new Thread(new Consumer(consumer,exchanger),"Consumer");
		
		prod.start();
		cons.start();
		
		
		
		
		
		
	}

}
