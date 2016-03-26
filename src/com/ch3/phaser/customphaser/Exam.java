package com.ch3.phaser.customphaser;


public class Exam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ExamPhaser examPhaser = new ExamPhaser();
		Thread[] students = new Thread[5];
		
		for (int i = 0; i < students.length; i++) {
			students[i] = new Thread(new Student(examPhaser),"Student "+i);
			examPhaser.register(); // This is because we didn't use Phaser constructor with participants.
		}
		
		for (int i = 0; i < students.length; i++) {
			students[i].start();
		}
		
		for (int i = 0; i < students.length; i++) {
			Thread thread = students[i];
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main : All done. Phaser status : %b %n",examPhaser.isTerminated());
	}

}
