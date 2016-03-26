package com.ch2.thread.condition;

import java.util.Arrays;
import java.util.Random;


public class FileMock {
	private String content[];
	private int index;
	

	public FileMock(int size, int length){
		content=new String[size];
		Random rnd = new Random();
		for (int i=0; i<size; i++){
			StringBuilder buffer=new StringBuilder(length);
			for (int j=0; j<length; j++){
				
				int chr = rnd.nextInt(91);
				while(chr < 65){
					chr = rnd.nextInt(91);
				}
				
				//int indice=(int)Math.random()*255;
				buffer.append((char)chr);
			}
			content[i]=buffer.toString();
			
		}
		System.out.println(Arrays.toString(content));
		index=0;
		
	}

	public boolean hasMoreLines(){
		return index<content.length;
	}

	public String getLine(){
		if (this.hasMoreLines()) {
			System.out.println("Mock: "+(content.length-index));
			return content[index++];
		}
		return null;
	}


}
