package com.acme.addressbook;

public class AddressBookApp {

	public static void main(String[] argv) {

		System.out.println("Start Address Book Manager App");
		
		// read address data (record) from text formatted file
		FileRecordLoader recLoader = new FileRecordLoader();
		recLoader.setFile("addrInput.txt");
		
		// filter (remove duplication) input data & sort it
		SortRecordFilter recFilter = new SortRecordFilter();
		
		// print out result
		//ScreenRecordWriter recWriter = new ScreenRecordWriter();
		TextFileWriter recWriter = new TextFileWriter();
		// AddressBookManager compose loader, filter, and writer... 
		// act as exception handler
		AddressBookManager addrBookMgr = new AddressBookManager();
		addrBookMgr.setLoader(recLoader);
		addrBookMgr.setFilter(recFilter);
		addrBookMgr.setWriter(recWriter);
		
		addrBookMgr.execute();
		
		System.out.println("End Address Book Manager App");
	}
}
