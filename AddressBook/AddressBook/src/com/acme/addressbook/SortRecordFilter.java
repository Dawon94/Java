package com.acme.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortRecordFilter implements RecordFilter {
	int check = 0;
	@Override
	public Set<Record> filter(List<Record> inputList) {

		SortedSet<Record> sorted = new TreeSet<Record>();
		for (Record rec : inputList) {
			// TODO before push record into set, remove duplication

			if(sorted.size() <= 0) {
				sorted.add(rec);
			}

			check = 0;

			for(Record sortedRec : sorted) {
				if(sortedRec.getEmail().equals(rec.getEmail())) {
					check = 1;
					break;
				}else if(sortedRec.getPhoneNo().equals(rec.getPhoneNo())) {
					check = 1;
					break;
				}
			}
			if(check == 0) {
				sorted.add(rec);
			}
		}

		return sorted;
	}
}
