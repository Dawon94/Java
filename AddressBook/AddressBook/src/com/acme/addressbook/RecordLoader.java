package com.acme.addressbook;

import java.util.List;

public interface RecordLoader {
	public List<Record> load() throws Exception;
}
