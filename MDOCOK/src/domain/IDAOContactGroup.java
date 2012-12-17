package domain;

import java.util.ArrayList;

public interface IDAOContactGroup {
	public ContactGroup addContactGroup(String groupName);
	
	public ContactGroup getContactGroup(long id);
	
	public boolean modifyContactGroup(long id, String groupename);
	
	public ArrayList<ContactGroup> getAllContactGroups();
	
	public ArrayList<ContactGroup> getContactGroups(String search);

}
