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

public class ContactDataGenerator {

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
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
		}

}
//-------------
	private static void saveContactsToXmlFile(List<ContactData> contacts, File file)  throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();

	}

public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException{
	XStream xstream = new XStream();
	xstream.alias("contact", ContactData.class);

	return (List<ContactData>) xstream.fromXML(file);

}
//-------------------CSV FILE----------------------	
	
	public static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter (file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," 
		    + contact.getLastName() + "," + contact.getAddress() +","
		    + contact.getHome()+"," + contact.getMobile()+"," 
		    + contact.getWork()+"," + contact.getEmail() +","
		    + contact.getSecodaryemail()+","
		    + contact.getBdday()+"," + contact.getBdmonth() +","
			+ contact.getBdyear()+"," + contact.getGroupName()+","
			+ contact.getSecondaryAddress()+"," + contact.getSecondaryHome()+",!" + "\n");
		}
		writer.close();

	}
	

	
	public static List<ContactData> LoadContactsFromCSVFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData().
					 withFirstName(part[0]).withLastName(part[1])
					.withAddress(part[2]).withHome(part[3])
					.withMobile(part[4]).withWork(part[5])	
					.withEmail(part[6]) .withSecodaryemail(part[7])
					.withBdday(part[8])	.withBdmonth(part[9])
					.withBdyear(part[10]).withGroupName(part[11])
					.withSecondaryAddress(part[12]).withSecondaryHome(part[13]);		
				
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}
	
	public static List<ContactData> generateRandomContacts(int amount) {
		List <ContactData> list =new ArrayList<ContactData > ();
    	Random rnd= new Random();
    	for (int i=0;i < amount; i++) {
    			ContactData contact =new ContactData()
    			.withFirstName (generateRandomString(10))
    			.withLastName (generateRandomString(10))
    			.withAddress (generateRandomString(10))
    			.withHome (generateRandomString(10))
    		    .withMobile (generateRandomString(10))
    			.withWork (generateRandomString(10))
    			.withEmail (generateRandomString(10))
    			.withSecodaryemail(generateRandomString(10))
    			.withBdday("10")
    			.withBdmonth("May")
    			.withBdyear("1985")
    			.withGroupName("Rob")
    			.withSecondaryAddress(generateRandomString(10))
    			.withSecondaryHome(generateRandomString(10));
    			
    		list.add (contact);
    		
    	}
    	
    	return list;
    }
	
//-------------GENERATE RANDOM STRING-----------------
	
	
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