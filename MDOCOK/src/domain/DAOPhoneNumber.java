package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tools.HibernateUtil;


public class DAOPhoneNumber implements IDAOPhoneNumber {

	@Override
	public PhoneNumber addPhoneNumber(String phoneKind, String phoneNumber) {
		PhoneNumber num=null;
		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();
			
			num = new PhoneNumber();
			num.setPhoneKind(phoneKind);
			num.setPhoneNumber(phoneNumber);
			
			session.save(num);
			
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return num;
	}

	@Override
	public PhoneNumber getPhoneNumber(long id) {
		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();
						
			Query q =session.createQuery("from ContactGroup as c where c.groupId = '"+id+"'");
			phones = q.list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return new ArrayList<PhoneNumber>(phones).get(0);
	}

	

	@Override
	public boolean modifyPhoneNumber(long id, String phoneKind, String phoneNumber) {
		PhoneNumber phone = this.getPhoneNumber(id);
		
		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			phone.setPhoneKind(phoneKind);
			phone.setPhoneNumber(phoneNumber);
			
			session.save(phone);
			tx.commit();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
		
	}

}
