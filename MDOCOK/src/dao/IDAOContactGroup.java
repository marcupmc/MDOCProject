package dao;

import java.util.ArrayList;

import domain.Contact;
import domain.ContactGroup;

public interface IDAOContactGroup {
	public ContactGroup addContactGroup(String groupName,long idOwner);
	
	public ContactGroup getContactGroup(long id);
	public ArrayList<ContactGroup> getContactGroupByOwner(long id);
	
	public boolean modifyContactGroup(long id, String groupename);
	
	public ArrayList<ContactGroup> getAllContactGroups();
	
	public ArrayList<ContactGroup> getContactGroups(String search);
	public boolean addContactToGroup(ContactGroup g, Contact c);
	
	public boolean removeContact(ContactGroup groupe,Contact contact);

}
