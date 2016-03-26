package com.ch5;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Action extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int start;
	private int end;
	private double increment;
	private List<Product> list;

	public Action(int start, int end, double increment, List<Product> list) {

		this.start = start;
		this.end = end;
		this.increment = increment;
		this.list = list;

	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		
		if ((this.end - this.start) < 100) {
			this.calculate();
		} else {			
			System.out.printf("QUEUED TASK COUNT %d%n",getQueuedTaskCount());
			int middle = (this.start + this.end) / 2;		
			/*System.out.printf("START = %d, END = %d%n",this.start,middle+1);
			System.out.printf("START = %d, END = %d%n",middle+1,this.end);*/
			Action a1 = new Action(this.start, middle+1, this.increment, list);
			Action a2 = new Action(middle + 1, this.end, this.increment, list);
			invokeAll(a1, a2);
		}

	}

	private void calculate() {
		for (int i = this.start; i < this.end; i++) {
			Product prod = list.get(i);			
			prod.setPrice(prod.getPrice() * (1 + this.increment));
		}
	}

}
