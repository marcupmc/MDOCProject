package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tools.HibernateUtil;


public class DAOAddress implements IDAOAddress {

	@Override
	public Address addAddress(String city, String country, String street, String zip) {
		Address add=null;
		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();
			
			add = new Address();
			add.setCity(city);
			add.setCountry(country);
			add.setStreet(street);
			add.setZip(zip);
			
			session.save(add);
			tx.commit();
			session.close();
			
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return add;
	}

	@Override
	public Address getAddress(long id) {
		List<Address> address = new ArrayList<Address>();

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();
						
			Query q =session.createQuery("from Address as c where c.id = '"+id+"'");
			address = q.list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return new ArrayList<Address>(address).get(0);
	}

	@Override
	public boolean modifyAddress(long id, String city, String country, String street,
			String zip) {
	
		Address toModify = this.getAddress(id);
		
		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();
						
			toModify.setCity(city);
			toModify.setCountry(country);
			toModify.setStreet(street);
			
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
