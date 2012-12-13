package domain;

import java.util.ArrayList;
import java.util.Set;

public interface IDAOContact {

	
	public Contact addContact(String firstname, String lastname, String email,Address add, Set<ContactGroup> groupes, Set<PhoneNumber> phones);
	
	public Contact addContact(Contact c);
	
	public int deleteContact(long id);
	
	public Contact getContact(long id);
	
	public boolean modifyContact(long id, String firstname, String lastname, String email,Address add, Set<ContactGroup> books, Set<PhoneNumber> phones);
	
	public ArrayList<Contact> getContactByFirstName(String firstname);
	
	public ArrayList<Contact> getContactByLastName(String lastname);
	
	public ArrayList<Contact> getContactByEmail(String email);
	
	public ArrayList<Contact> getAllContact();
	
}
