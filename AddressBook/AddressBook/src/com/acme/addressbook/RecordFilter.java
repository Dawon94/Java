package com.acme.addressbook;

import java.util.List;
import java.util.Set;

public interface RecordFilter {

	Set<Record> filter(List<Record> inputList);
}
