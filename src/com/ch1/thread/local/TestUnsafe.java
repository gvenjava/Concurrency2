package com.ch1.thread.local;

import java.util.concurrent.TimeUnit;

public class TestUnsafe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Safe obj = new Safe();
		
		for(int i=1;i<=3;i++){			
			Thread t1 = new Thread(obj);
			t1.start();
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("COMPLTED!!!");
	}

}
