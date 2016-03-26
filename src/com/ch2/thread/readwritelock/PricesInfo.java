package com.ch2.thread.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {
	private double price1;
	private double price2;

	private ReadWriteLock lock;

	public PricesInfo(){
		price1=1.0;
		price2=2.0;
		lock=new ReentrantReadWriteLock();
	}

	public double getPrice1() {
		lock.readLock().lock();
		double value=price1;
		price1=-570.0;
		lock.readLock().unlock();
		return value;
	}

	public double getPrice2() {
		lock.readLock().lock();
		double value=price2;
		price2 = -990.0;
		lock.readLock().unlock();
		return value;
	}

	public void setPrices(double price1, double price2) {
		lock.writeLock().lock();
		this.price1=price1;
		this.price2=price2;
		lock.writeLock().unlock();
	}

}
