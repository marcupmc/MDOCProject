package dao;

import java.util.ArrayList;
import java.util.Set;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

public interface IDAOContact {

	
	public Contact addContact(String firstname, String lastname, String email,Address add, Set<ContactGroup> groupes, Set<PhoneNumber> phones);
	
	public Contact addContact(Contact c);
	
	public int deleteContact(long id);
	
	public Contact getContact(long id);
	
	public boolean modifyContact(long id, String firstname, String lastname, String email);
	
	public ArrayList<Contact> getContactByFirstName(String firstname);
	
	public ArrayList<Contact> getContactByLastName(String lastname);
	
	public ArrayList<Contact> getContactByEmail(String email);
	
	public ArrayList<Contact> getAllContact();
	
	public boolean addFriend(Contact online, Contact friend);
	
	public boolean deleteFriend(Contact online, Contact friend);
	
	public boolean modifyPicture(Contact online, String pathPic);
	
	//public Contact addContactGroup(Contact c ,ContactGroup g);
}
