package com.philips.receiver.operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.opencsv.CSVWriter;
import com.philips.receiver.service.IWriter;

public class CsvWrite implements IWriter{
	
	public void generateCsvFile(Map<String,Integer> wordCount, String filepath){
		
		File file = new File(filepath);
		try{
			
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile); 
			
			String[] header = { "word", "count"}; 
	        writer.writeNext(header); 
	  
	        // add data to csv 
	        for(Map.Entry<String, Integer> entry: wordCount.entrySet()){
	        	String[] countPair = {entry.getKey(), entry.getValue().toString()};
	        	writer.writeNext(countPair);
	        }
	  
	        // closing writer connection 
	        writer.close(); 
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
