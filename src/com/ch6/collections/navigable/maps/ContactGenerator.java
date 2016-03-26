package com.ch6.collections.navigable.maps;

import java.util.concurrent.ConcurrentSkipListMap;

/** Creates 1000 contacts and stores them in the navigable map. */
public class ContactGenerator implements Runnable {

	private ConcurrentSkipListMap<String, Contact> map;
	private String id;

	public ContactGenerator(ConcurrentSkipListMap<String, Contact> map, String id) {
		this.map = map;
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Contact contact = new Contact(id, String.valueOf(i + 1000));
			map.put(id + contact.getPhone(), contact);
		}
	}

}
