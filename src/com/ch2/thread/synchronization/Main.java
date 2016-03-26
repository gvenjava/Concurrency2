package com.ch2.thread.synchronization;

public class Main {

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);

		Bank bank = new Bank(account);
		Company company = new Company(account);

		Thread bankThread = new Thread(bank);
		Thread companyThread = new Thread(company);

		System.out.printf("Account : Initial Balance: %f\n",account.
				getBalance());
		companyThread.start();
		bankThread.start();

		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account : Final Balance: %f\n",account.
					getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
