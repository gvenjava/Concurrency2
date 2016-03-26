package com.ch1.thread.daemon;

import java.util.Date;

public class Event {
	private Date date;
	private String event;
	
	public final Date getDate() {
		return date;
	}
	public final void setDate(Date date) {
		this.date = date;
	}
	public final String getEvent() {
		return event;
	}
	public final void setEvent(String event) {
		this.event = event;
	}
	
}
