package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;



public class GroupDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please, specify following parametrs: <amount of test data> <file> <format>");
			return;
		
	}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
		}
		
		List<GroupData> groups = generateRandomGroups(amount);
		if ("csv".equals(format)) {
			saveGroupsToCsvFile(groups, file);
		} else if ("xml".equals(format)) {
			saveGroupsToXmlFile(groups, file);
		} else {
			System.out.println("Unknown format" + format);
		}

}
	
//XML FILE-----------------------------------------------------------
	
	private static void saveGroupsToXmlFile(List<GroupData> groups, File file)  throws IOException {
			XStream xstream = new XStream();
			xstream.alias("group", GroupData.class);
			String xml = xstream.toXML(groups);
			FileWriter writer = new FileWriter(file);
			writer.write(xml);
			writer.close();

		}
	
	public static List<GroupData> loadGroupsFromXmlFile(File file) throws IOException{
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);

		return (List<GroupData>) xstream.fromXML(file);

	}
	
	//CSV FILE-----------------------------------------------------------
	
	public static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
		FileWriter writer = new FileWriter (file);
		for (GroupData group : groups) {
			writer.write(group.getGroupname() + "," + group.getHeader() + "," + group.getFooter() + ",!" + "\n");
		}
		writer.close();

	}
	
	public static List<GroupData> loadGroupsFromCSVFile(File file) throws IOException {
		List<GroupData> list = new ArrayList<GroupData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			GroupData group = new GroupData().withGroupName(part[0]).withHeader(part[1]).withFooter(part[2]);
			list.add(group);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	
//------------------------------------	
	public static List<GroupData> generateRandomGroups(int amount) {
		List <GroupData> list =new ArrayList<GroupData> ();
    	Random rnd= new Random();
    	for (int i=0;i < amount; i++) {
    		GroupData group =new GroupData()
    		.withGroupName(generateRandomString(10))
    		.withHeader(generateRandomString(10))
    		.withFooter(generateRandomString(10));
    		
    		list.add (group);
    		
    	}
    	
    	return list;
    }
	
	public static String generateRandomString(int length) {
		   final char[] KEYCHARS = "0123456789ABCDEFGhijklmnopqrstuvwxyz±$!@#%&*()".toCharArray();
			  Random randomizer = new Random();
			  char[] randomString = new char[length];
		Random rnd=new Random ();
		if (rnd.nextInt(3)==0) {return "";}
		else {
			  for (int i = 0; i < length; i++) {
		       randomString[i] = KEYCHARS[randomizer.nextInt(KEYCHARS.length)];
		   }
		  return new String(randomString);
			}}
	
}

