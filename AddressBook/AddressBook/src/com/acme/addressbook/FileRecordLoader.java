package com.acme.addressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileRecordLoader implements RecordLoader {

	private String filePath;

	@Override
	public List<Record> load() throws Exception {
		File inputFile = new File(filePath);
		InputStream inputStream = new FileInputStream(inputFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));

		List<Record> recordList = new ArrayList<Record>(); 
		while (reader.ready()) {
			String line = reader.readLine();
			System.out.println(line);
			
			// TODO parse input data & create record... push record into list
			
			String[] parsedData = line.split(";");
			Record record = new Record(parsedData[0], parsedData[1], parsedData[2]);
			
			recordList.add(record);
		}

		return recordList;
	}

	public void setFile(String filePath) {
		this.filePath = filePath;
	}
}
