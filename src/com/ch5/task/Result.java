package com.ch5.task;

public class Result {

	private String timeStamp;

	private String before;
	
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	@Override
	public String toString() {
		return "Result [Before Sleep = " + before + " Woke Up At = " + timeStamp + "]";
	}
	
	
	
}
