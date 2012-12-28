package dao;

import java.util.Set;

import domain.Address;

public interface IDAOAddress {

	public Address addAddress(String city, String country, String street, String zip);
	
	public Address getAddress(long id);
	
	public boolean modifyAddress(long id, String city, String country, String street, String zip);
}
