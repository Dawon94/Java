package com.acme.addressbook;

import java.util.Iterator;
import java.util.Set;

public class ScreenRecordWriter implements RecordWriter {

	@Override
	public void write(Set<Record> filterSet) {
		
		System.out.println("\nPrint filtered record list");

		Iterator<Record> iter = filterSet.iterator();
		while (iter.hasNext()) {
			Record rec = iter.next();
			System.out.println(rec);
		}
	}
}
