package com.ch4.ecs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.ch4.runnable.Task;

public class ProcessECS {

	public void execute() {
		List<Future<Result>> future = null;
		List<Result> result = new ArrayList<Result>();
		ThreadPoolExecutor service = (ThreadPoolExecutor) Executors
				.newCachedThreadPool();


		service.setRejectedExecutionHandler(new RejectedExecutionHandler() {

			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
				// TODO Auto-generated method stub
				System.out.printf("Thread Name %s could not be processed%n", r);
				System.out.printf("Executor Information %s%n", e);
				System.out.printf("Executor is Terminating %b%n",
						e.isTerminating());
				System.out.printf("Executor is Terminated %b%n",
						e.isTerminated());
			}
		});

		for (int i = 0; i < 10; i++) {

			result.add(new Result(i + 1));
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ExecutorCompletionService<Result> ecs = new ExecutorCompletionService<Result>(
				service);

		future = new ArrayList<>(result.size());

		for (Result res : result)
			future.add(ecs.submit(res));

		Result r1 = null;

		try {
			for (int i = 0; i < result.size(); i++) {
				System.out.println("before get...");
				r1 = ecs.take().get();

				if (null != r1) {
					System.out.println(r1);
					break;
				}
			}

		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("EXECUTOR = " + service);
			service.shutdown();

			int i = 0;
			for (Future<Result> fr : future) {

				if (!fr.isDone()) {
					i++;
					System.out.println(i + " Cancellation in progress...");
					fr.cancel(true);
				}
			}
			service.submit(new Task("CANCELLATION THREAD "));
		}
	}

	public static void main(String[] args) {

		ProcessECS ecs = new ProcessECS();
		ecs.execute();
	}
}
