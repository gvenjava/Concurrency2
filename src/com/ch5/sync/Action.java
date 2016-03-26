package com.ch5.sync;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Action extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Integer> events;

	private int computationThreshold;

	private String name;

	private static int count = 0;

	private int start;

	private int end;

	public Action(List<Integer> list, int thresHold, String n, int s, int e) {
		this.events = list;
		this.computationThreshold = thresHold;
		this.name = n;
		this.start = s;
		this.end = e;
	}

	private void execute() {

		for(int i = this.start; i<this.end;i++){
			System.out.printf("Name : %s - %d%n",this.name,this.events.get(i));
		}
		
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub

		try {
			if ((this.end - this.start) < this.computationThreshold) {
				this.execute();
			} else {

				int middle = (this.start + this.end) / 2;

				Action left = new Action(this.events,
						this.computationThreshold, this.name + (++count),
						this.start, middle + 1);
				Action right = new Action(this.events,
						this.computationThreshold, this.name + (++count),
						middle + 1, this.end);

				invokeAll(left, right);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
