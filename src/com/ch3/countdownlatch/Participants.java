package com.ch3.countdownlatch;

import java.util.concurrent.TimeUnit;

public class Participants implements Runnable {
	
	Videoconference videoconference;
	String name;
	
	public Participants(Videoconference videoconference, String name) {
		this.videoconference = videoconference;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep((long)(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		videoconference.arrived(name);
		System.out.println("I'm done."+name);
	}

}
