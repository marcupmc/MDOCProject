package domain;

public interface IDAOContactGroup {
	public ContactGroup addContactGroup(String groupName);
	
	public ContactGroup getContactGroup(long id);
	
	public boolean modifyContactGroup(long id, String groupename);
	

}
