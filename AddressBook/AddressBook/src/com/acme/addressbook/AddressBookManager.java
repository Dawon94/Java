package com.acme.addressbook;

import java.util.List;
import java.util.Set;

/**
 * Address Book Manager
 * (주소록 매니저)
 * 
 * AddressBookManager compose loader, filter, and writer... 
 * act as exception handler
 * 주소록 데이터를 읽어 들이고, 데이터 정리를 수행한 후, 결과를 출력한다.
 * 또한 각 컴포넌트 실행 중 발생하는 예외를 처리한다.
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
