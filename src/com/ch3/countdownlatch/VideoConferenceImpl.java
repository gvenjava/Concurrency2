package com.ch3.countdownlatch;

public class VideoConferenceImpl {

	public VideoConferenceImpl() {
	}

	public static void main(String[] args) {
		Videoconference videoconference = new Videoconference(10);
		Thread thread = new Thread(videoconference);
		thread.start();
		
		for (int i = 0; i < 10; i++) {
			Participants participants = new Participants(videoconference, "Participant "+i);
			Thread threadPart = new Thread(participants);
			threadPart.start();
		}
		
	}

}
