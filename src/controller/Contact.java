package controller;

public class Contact {
	private String name;
	private String phoneNumber;

	public String getName() {
		return name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Contact(String name, String phone) {
		super();
		this.name = name;
		this.phoneNumber = phone;
	}
public static Contact createContact(String name, String phone){
	return new Contact(name,phone);
}
	
}
