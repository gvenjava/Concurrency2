package com.ch3.semaphores.tryacquire;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class AcquireTest {

	public static void main(String[] args) {
		Semaphore sema = new Semaphore(1);
		Thread[] obj = new Thread[2];
		int j = 1;
		for (int i = 0; i < obj.length; i++) {
			
			if(i == 0)
				j = 10;
			else
				j = 1;
			
			obj[i] = new Thread(new ExThread((i * 3) + j, sema));
		}
		
		/*for(int i =0; i<obj.length; i++){
			obj[i].start();
		}*/
		
		try {
			obj[0].start();
			TimeUnit.MILLISECONDS.sleep(10);
			obj[1].start();
			TimeUnit.SECONDS.sleep(2);
//			obj[1].interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();			
			System.out.println(e.getMessage());
		}
		
		

	}

}
