package controller;

import java.util.Scanner;

public class Main {
	private static Scanner scanner=new Scanner(System.in);
	private static MobilePhone mobilePhone=new MobilePhone("469-543-7911"); 
	public static void main(String args[]){
		boolean quit=false;
		startPhone();
		printActions();
		while(!quit){
			System.out.println("\nEnter action: (6 to show available actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			switch(action){
			case 0:
				System.out.println("\n shutting down....");
				quit=true;
				break;
			case 1:
				mobilePhone.printContacts();
				break;
			case 2:
				addnewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printActions();
				break;
			}
		}
		
		
	}
	private static void queryContact() {
		System.out.println("enter existing contact name");
		String name=scanner.nextLine();
		Contact existingContactRecord =mobilePhone.queryContact(name);
		if(existingContactRecord==null){
			System.out.println("contact not found");
			return;
		}
		System.out.println("Name:"+existingContactRecord.getName()+" Phone number:"+existingContactRecord.getPhoneNumber());
	}
	private static void removeContact() {
		System.out.println("enter existing contact name");
		String name=scanner.nextLine();
		Contact existingContactRecord =mobilePhone.queryContact(name);
		if(existingContactRecord==null){
			System.out.println("contact not found");
			return;
		}
		if(mobilePhone.removeContact(existingContactRecord)){
			System.out.println("removed successfully");
		}
		else{
			System.out.println("Error deleting");
		}
		
	}
	private static void updateContact() {
		System.out.println("enter existing contact name");
		String name=scanner.nextLine();
		Contact existingContactRecord =mobilePhone.queryContact(name);
		if(existingContactRecord==null){
			System.out.println("contact not found");
			return;
		}
		System.out.println("enter new contact name");
		String newName=scanner.nextLine();
		System.out.println("enter new mobile number");
		String newNumber=scanner.nextLine();
		Contact newContact=Contact.createContact(newName, newNumber);
		if(mobilePhone.updateContact(existingContactRecord, newContact)){
			System.out.println("successfully updated contact record");
		}
		else{
			System.out.println("error updating record");
		}
		
	}
	private static void addnewContact() {
		System.out.println("Enter new Contact Name:");
		String name=scanner.nextLine();
		System.out.println("Enter phone number");
		String phone=scanner.nextLine();
		Contact newContact=Contact.createContact(name, phone);
		if(mobilePhone.addNewContact(newContact)){
			System.out.println("New contact added: "+"name = "+name+" phone ="+phone);
		}
		else{
			System.out.println("cannot add contact" +name+" already on file");
		}
	}
	
	private static void printActions() {
		System.out.println("\n Available actions:\n press");
		System.out.println("0 shut down");
		System.out.println("1 - print contacts");
		System.out.println("2 - add new contacts");
		System.out.println("3 - update existing contact");
		System.out.println("4 - remove existing contact");
		System.out.println("5 - querying existing contact");
		System.out.println("6 - To print list of available actions");
		System.out.println("Choos your action: ");
	}
	private static void startPhone() {
		System.out.println("starting phone ....");
		
	}
	
}
