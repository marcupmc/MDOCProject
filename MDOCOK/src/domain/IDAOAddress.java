package domain;

import java.util.Set;

public interface IDAOAddress {

	public Address addAddress(String city, String country, String street, String zip);
	
	public Address getAddress(long id);
	
	public boolean modifyAddress(long id, String city, String country, String street, String zip);
}
