package com.acme.addressbook;

import java.util.List;
import java.util.Set;

/**
 * Address Book Manager
 * (�ּҷ� �Ŵ���)
 * 
 * AddressBookManager compose loader, filter, and writer... 
 * act as exception handler
 * �ּҷ� �����͸� �о� ���̰�, ������ ������ ������ ��, ����� ����Ѵ�.
 * ���� �� ������Ʈ ���� �� �߻��ϴ� ���ܸ� ó���Ѵ�.
 */
public class AddressBookManager {

	private RecordLoader recLoader;
	private RecordFilter recFilter;
	private RecordWriter recWriter;

	public void setLoader(RecordLoader recLoader) {
		this.recLoader = recLoader;
	}

	public void setFilter(RecordFilter recFilter) {
		this.recFilter = recFilter;
	}

	public void setWriter(RecordWriter recWriter) {
		this.recWriter = recWriter;
	}

	public void execute() {

		try {
			List<Record> inputList = recLoader.load();
			System.out.println( "\ninput record count : " + inputList.size() );
			
			Set<Record> filteredSet = recFilter.filter(inputList);
			System.out.println( "\nfiltered record count : " + filteredSet.size() );
			
			recWriter.write(filteredSet);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
