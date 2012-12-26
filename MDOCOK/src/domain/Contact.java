package domain;

import java.util.HashSet;
import java.util.Set;

public class Contact {

	private String firstName;
	private String lastName;
	private String email;
	private long id;
	private Set<ContactGroup> books=new HashSet<ContactGroup>();
	private Address add;
	private Set<PhoneNumber> phones=new HashSet<PhoneNumber>();
	
	//Ajout pour Social Network
	private Set<Contact> friends = new HashSet<Contact>();
	
	public Contact(){
	
	}
	
	public Contact(String firstName,String lastName, String email, Set<ContactGroup> books, Address add,
			Set<PhoneNumber> phones){
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.books=books;
		this.add=add;
		this.phones=phones;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<ContactGroup> getBooks() {
		return books;
	}

	public void setBooks(Set<ContactGroup> books) {
		this.books = books;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}

	public Set<Contact> getFriends() {
		return friends;
	}

	public void setFriends(Set<Contact> friends) {
		this.friends = friends;
	}
	
	
	
}
