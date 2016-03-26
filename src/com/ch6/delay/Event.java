package com.ch6.delay;

import java.util.Calendar;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Event implements Delayed {

	private Calendar expiryTime;

	public Event(Calendar time) {
		this.expiryTime = time;
	}

	@Override
	public int compareTo(Delayed d) {
		// TODO Auto-generated method stub

		Integer current = new Integer((int) TimeUnit.SECONDS.convert(expiryTime.getTimeInMillis(), TimeUnit.SECONDS));
		Integer target = new Integer((int) d.getDelay(TimeUnit.SECONDS));
		
		System.out.printf("CURRENT %d, TARGET %d%n",current,target);
		
		return current.compareTo(target);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return expiryTime.getTimeInMillis()
				- Calendar.getInstance().getTimeInMillis();
	}

}
