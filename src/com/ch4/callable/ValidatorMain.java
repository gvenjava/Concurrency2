package com.ch4.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ValidatorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		List<TaskValidator> list = new ArrayList<>();
		
		list.add(new TaskValidator("Gaja",new UserValidator("Gaja","nothing")));
		list.add(new TaskValidator("KV",new UserValidator("KV","nothing")));
		String future = null;
		try {
			future = service.invokeAny(list);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		service.shutdown();
		
		System.out.printf("Success Message ::: %s",future);
		
		
	}
}
