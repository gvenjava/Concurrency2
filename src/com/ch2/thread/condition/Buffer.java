package com.ch2.thread.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;

	public Buffer(int maxSize) {
		this.maxSize=maxSize;
		buffer=new LinkedList<>();
		lock=new ReentrantLock();
		lines=lock.newCondition();
		space=lock.newCondition();
		pendingLines=true;
	}

	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.awaitUninterruptibly();
//				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s: %s Inserted Line: %d\n", Thread.
					currentThread().getName(),Thread.currentThread().isInterrupted(),buffer.size());
			lines.signalAll();
		} catch (Exception  e) {	
			System.out.printf("%s ::: %s: %s Inserted Line: %d\n","---EXCEPTION---", Thread.
					currentThread().getName(),Thread.currentThread().isInterrupted(),buffer.size());
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String get() {
		String line=null;
		lock.lock();
		try {
			while ((buffer.size() == 0) &&(hasPendingLines())) {
				lines.await();
			}
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d\n",Thread.
						currentThread().getName(),buffer.size());
				space.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return line;
	}

	public void setPendingLines(boolean pendingLines) {
		this.pendingLines=pendingLines;
	}

	public boolean hasPendingLines() {
		return pendingLines || buffer.size()>0;
	}
}
