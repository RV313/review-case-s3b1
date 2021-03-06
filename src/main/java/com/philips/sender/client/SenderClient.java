package com.philips.sender.client;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.philips.sender.service.IPrintToConsole;
import com.philips.sender.operation.CsvReader;
import com.philips.sender.operation.PrintToConsole;

public class SenderClient {

	public static void main(String[] args)
	{
		String log4jConfPath = "src/main/resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		String filepath = args[0];
		String columnName = args[1];
		
		CsvReader csvReadObject = new CsvReader(filepath);
 
		List<String[]>  listStringArrayObject = csvReadObject.readUsingBufferedReader();
		
		IPrintToConsole ptc = new PrintToConsole();
		int index = ptc.getIndexForColumnName(listStringArrayObject.get(0), columnName);
		ptc.printToConsole(listStringArrayObject, index);
	}
}
