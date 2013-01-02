package dao;

import domain.Contact;
import domain.PhoneNumber;


public interface IDAOPhoneNumber {

		public PhoneNumber addPhoneNumber(String phoneKind, String phoneNumber);
		
		public PhoneNumber addPhoneNumber(PhoneNumber n);
		
		public PhoneNumber getPhoneNumber(long id);
		
		public boolean modifyPhoneNumber(long id, String phoneKind, String phoneNumber);
		
		public PhoneNumber addPhoneNumber(PhoneNumber num, Contact c);
}
