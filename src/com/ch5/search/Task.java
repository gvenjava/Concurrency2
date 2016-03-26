package com.ch5.search;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<List<String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dir;
	private String ext;

	public Task(String dir, String ext) {
		this.dir = dir;
		this.ext = ext;
	}

	@Override
	public String toString() {
		return "DIR = " + dir + ", EXT = " + ext;
	}

	private void getData(List<String> list, List<Task> task) throws Exception  {
		int tmp = 0;
		for (Task t : task){
			tmp++;
			list.addAll(t.join());
			if(tmp == 25){
				throw new Exception("Intentional Exception = "+this);
			}
		}
			
	}

	@Override
	protected List<String> compute() {
		// TODO Auto-generated method stub

		File f = new File(this.dir);
		File[] objs = f.listFiles();
		List<String> file = new ArrayList<>();
		List<Task> tasks = new ArrayList<>();

		if (null != objs) {
			for (File obj : objs) {				
				if (obj.isDirectory()) {
					Task t1 = new Task(obj.getAbsolutePath(), this.ext);
					t1.fork();
					tasks.add(t1);
				} else {
					if (obj.getName().endsWith(this.ext)) {
						file.add(obj.getAbsolutePath());
					}
				}
			}
		}
		
		
		
		try {
			getData(file, tasks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			this.completeExceptionally(new ExecutionException("****WRAPPED FROM COMPUTE METHOD****",e));
		}
		return file;
	}
}
