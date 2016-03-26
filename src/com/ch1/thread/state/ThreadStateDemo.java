package com.ch1.thread.state;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class ThreadStateDemo{

	static void writeState(PrintWriter pw,Thread t,State state){
		
		pw.write("THREAD ID       			: "+t.getId()+"\n");
		pw.write("THREAD NAME     			: "+t.getName()+"\n");
		pw.write("THREAD PRIORITY 			: "+t.getPriority()+"\n");
		pw.write("THREAD OLD STATE    		: "+state+"\n");
		pw.write("THREAD CURRENT STATE    	: "+t.getState()+"\n");		
		pw.write("***************************************************************************************************\n");
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileWriter fw = null;
		PrintWriter pw = null;
		Thread.State[] state = new Thread.State[10];
		Thread[] thread = new Thread[10];
		
		
		
		fw = new FileWriter("data/log.txt");
		pw = new PrintWriter(fw);
		
		for(int i=1;i<=10;i++){
			thread[i-1] = new Thread(new Calculator(i));
			state[i-1] = thread[i-1].getState();
			
			if(i % 2 == 0){
				thread[i-1].setPriority(Thread.MAX_PRIORITY);
			}else{
				thread[i-1].setPriority(Thread.MIN_PRIORITY);
			}
			
			thread[i-1].setName("THREAD - "+i);			
			writeState(pw,thread[i-1],state[i-1]);			
		}
		
		for(int i=0;i<10;i++)
			thread[i].start();
		
		boolean flag = false;
		
		while(!flag){			
			for(int i = 0; i<10; i++){
				if(thread[i].getState() != state[i]){
					writeState(pw,thread[i],state[i]);
					state[i] = thread[i].getState();
				}
			}
			
			flag = true;
			for(int i = 0;i<10;i++){
				flag = flag && (thread[i].getState() == Thread.State.TERMINATED);
				/*if(thread[i].getState() != Thread.State.TERMINATED){
					flag = true;
					break;
				}			*/	
			} 			
		}
	}

}
