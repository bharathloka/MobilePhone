package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;
	private static Scanner sc = new Scanner(System.in);

	public MobilePhone(String myNumber) {
		super();
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();
	}

	public boolean addNewContact(Contact contact) {
		if (findContact(contact.getName()) >= 0) {
			System.out.println("contact already exists");
			return false;
		}
		myContacts.add(contact);
		return true;
	}

	public boolean updateContact(Contact oldContact, Contact newContact) {
		int foundPosition = findContact(oldContact);
		if (foundPosition < 0) {
			System.out.println(oldContact.getName() + "was not found");
			return false;
		}
		this.myContacts.set(foundPosition, newContact);
		System.out.println(oldContact.getName() + " was replaced with "
				+ newContact.getName());
		return true;
	}

	private int findContact(Contact contact) {
		return this.myContacts.indexOf(contact);
	}

	private int findContact(String contactName) {
		for (int i = 0; i < this.myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);
			if (contact.getName().equals(contactName))
				return i;
		}
		return -1;
	}

	public String queryContact(Contact contact) {
		if (findContact(contact) > 0) {
			return contact.getName();
		}
		return null;
	}

	public boolean removeContact(Contact contact) {
		int foundPosition = findContact(contact);
		if (foundPosition < 0) {
			System.out.println("contact not found");
			return false;
		}
		this.myContacts.remove(foundPosition);
		System.out.println("contact successfully deleted");
		return true;
	}

	public void printContacts() {
		System.out.println("Contact List:");
		int i=1;
		for (Contact contact : myContacts) {
			System.out.println(i+"."+ contact.getName()+ "->"+contact.getPhoneNumber());
		i++;
		}
		
	}

	public Contact queryContact(String name) {
		int position=findContact(name);
		if(position>=0){
			return this.myContacts.get(position);
		}
		return null;
			
	}

}
