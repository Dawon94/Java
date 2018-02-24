package com.acme.addressbook;

import java.util.Set;

public interface RecordWriter {
	void write(Set<Record> filterSet);
}
