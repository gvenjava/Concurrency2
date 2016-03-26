package com.ch3.phaser.customphaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {

	private Phaser phaser;
	
	public Student(Phaser ph) {
		this.phaser = ph;
	}

	@Override
	public void run() {
		System.out.printf("Student %s has arrived.%n",Thread.currentThread().getName());
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("Student %s has started exercise 1.%n",Thread.currentThread().getName());
		
		doExercise1();
		
		System.out.printf("Student %s has done exercise 1.%n",Thread.currentThread().getName());
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("Student %s has started exercise 2.%n",Thread.currentThread().getName());
		
		doExercise2();
		
		System.out.printf("Student %s has done exercise 2.%n",Thread.currentThread().getName());
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.printf("Student %s has started exercise 3.%n",Thread.currentThread().getName());
		
		doExercise3();
		
		System.out.printf("Student %s has done exercise 3.%n",Thread.currentThread().getName());
		
		phaser.arriveAndAwaitAdvance();
		
		
	}

	private void doExercise3() {
		doTask();
	}

	private void doExercise2() {
		doTask();
	}

	private void doExercise1() {
		doTask();
	}

	private void doTask() {
		try {
			TimeUnit.SECONDS.sleep((long)(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
