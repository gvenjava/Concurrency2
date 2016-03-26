package com.ch1.thread.local;

public class ChangeLocal implements Runnable {
	String t1 = "Parent";
InheritableThreadLocal<String> local = new InheritableThreadLocal<String>(){
	@Override
	public String initialValue(){
		return "Parent";
	}
	
	@Override
	public String childValue(String t){
		return t;
	}
	
};
	@Override
	public void run() {
		// TODO Auto-generated method stub	
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				t1 = "Child";
				local.set(t1);
				// TODO Auto-generated method stub
				Thread t3 = new Thread(new Runnable() {

					@Override
					public void run() {
						t1 = "Grand Child";
						local.set(t1);
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName()+" --- "+local.get()+" --- "+t1);
					}

				}, "Thread - 3");
				
				t3.start();
				
			/*	try {
					t3.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				System.out.println(Thread.currentThread().getName()+" --- "+local.get()+" --- "+t1);
			}

		}, "Thread - 2");
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" --- "+local.get()+" --- "+t1);
	}

	public static void main(String[] args) {
		Thread obj = new Thread(new ChangeLocal(),"Thread - 1");
		
		obj.start();
		
		/*try {
			obj.join();
		} catch (InterruptedException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
