package com.ch3.phaser;

import java.util.concurrent.Phaser;

public class TestPhaser {

	public TestPhaser() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Phaser phaser=new Phaser(3);
		FileSearch system=new FileSearch("C:\\Windows", "log",
				phaser);
		FileSearch apps=
				new FileSearch("C:\\Program Files","log",phaser);
		FileSearch documents=
				new FileSearch("C:\\Eclipse","log",phaser);
		
//		FileSearch users=
//				new FileSearch("C:\\Users","log",phaser);
		
		Thread systemThread=new Thread(system,"System");
		systemThread.start();
		Thread appsThread=new Thread(apps,"Apps");
		appsThread.start();
		Thread documentsThread=new Thread(documents, "Documents");
		documentsThread.start();
		
//		Thread usersThread=new Thread(users, "Users");
//		usersThread.start();
		
		try {
			systemThread.join();
			appsThread.join();
			documentsThread.join();
//			usersThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminated: "+ phaser.isTerminated());

	}

}
