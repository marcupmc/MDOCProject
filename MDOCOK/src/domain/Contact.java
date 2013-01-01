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
	private String password;
	private String imagePerso="images_perso/default_perso.png";
	
	//Ajout pour Social Network
	private Set<Contact> persons = new HashSet<Contact>();
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


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return " Prenom : "+firstName +"\n email : "+ email +"\n password : "+ password; 
	}

	public Set<Contact> getFriends() {
		return friends;
	}

	public void setFriends(Set<Contact> friends) {
		this.friends = friends;
	}

	public Set<Contact> getPersons() {
		return persons;
	}

	public void setPersons(Set<Contact> persons) {
		this.persons = persons;
	}

	public String getImagePerso() {
		return imagePerso;
	}

	public void setImagePerso(String imagePerso) {
		this.imagePerso = imagePerso;
	}


	
}
