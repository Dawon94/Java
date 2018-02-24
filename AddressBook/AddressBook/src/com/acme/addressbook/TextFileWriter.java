package com.acme.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class TextFileWriter implements RecordWriter {

	@Override
	public void write(Set<Record> filterSet) {
		// TODO Auto-generated method stub
		System.out.println("\nPrint filtered record list");

		Iterator<Record> iter = filterSet.iterator();
		File file = new File("resultOutput.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file, true);
			while (iter.hasNext()) {
				Record rec = iter.next();
				fw.write("{\r\n");
				fw.write("name : " + rec.getName() + "\r\n" );
				fw.write("email : " + rec.getEmail() + "\r\n");
				fw.write("phoneNo : " + rec.getPhoneNo() + "\r\n");
				fw.write("}\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
