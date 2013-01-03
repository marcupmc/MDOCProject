package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import tools.HibernateUtil;
import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.Messages;
import domain.PhoneNumber;


public class DAOContact extends HibernateDaoSupport implements IDAOContact{

	private HibernateTemplate hibernateTemplate; 

	public void setHibernateTemplate(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}


	/**
	 * Rajoute un contact dans la base de donnees.
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return renvoit le nouveau contact
	 */
	public Contact addContact(String firstname, String lastname, String email,Address add, Set<ContactGroup> groupes, Set<PhoneNumber> phones){
		Contact	contact = new Contact();
		contact.setAdd(add);
		contact.setEmail(email);
		contact.setFirstName(firstname);
		contact.setLastName(lastname);
		contact.setBooks(groupes);
		contact.setPhones(phones);
		try{
			getHibernateTemplate().save(contact);
		}catch(Exception e){
			return null;
		}
		return contact;
	}

	/**
	 * Suppresion d'un contact a partir de son identifiant
	 * @param id
	 * @return vrai si la suppression a bien ete effectuee
	 */
	public boolean deleteContact(long id){
		Contact c = this.getContact(id);
		try{
			getHibernateTemplate().delete(c);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//		Session session=null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//			session.delete(c);
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//			return false;
	//		}


	//ok
	/**
	 * Recuperation d'un contact a partir de son identifiant
	 * @param id
	 * @return
	 */
	public Contact getContact(long id){
		try{
			return (Contact)getHibernateTemplate().find("from Contact as c where c.id =?",id).get(0);
		}catch(Exception e){
			return null;
		}
	}

	//ok
	//	/**
	//	 * Recuperation d'un contact a partir de son identifiant
	//	 * @param id
	//	 * @return
	//	 */
	//	public Contact getContact_old(long id){
	//
	//		List<Contact> contacts = new ArrayList<Contact>();
	//
	//		Session session=null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//			Query q =session.createQuery("from Contact as c where c.id = '"+id+"'");
	//			contacts = q.list();
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//		}
	//
	//		return new ArrayList<Contact>(contacts).get(0);
	//	}

	//unused
	/**
	 * Methode qui modifie les coordonees d'un contact
	 * @param id
	 * @param firstname
	 * @param alstname
	 * @param email
	 * @return
	 */
	public boolean modifyContact(long id, String firstname, String lastname, String email){
		Contact toModify = this.getContact(id);
		toModify.setEmail(email);
		toModify.setLastName(lastname);
		toModify.setFirstName(firstname);
		try{
			getHibernateTemplate().update(toModify);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}


	//ok
	/**
	 * Renvoit la liste des contacts correspondant au prenom firrstname
	 * @param firstname
	 * @return
	 */
	public ArrayList<Contact> getContactByFirstName(String firstname){

		List<Contact> contacts = new ArrayList<Contact>();
		Contact c = new Contact();
		c.setFirstName(firstname);
		try{
			contacts = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Contact.class).add(Example.create(c)));
		}catch(Exception e){
			return null;
		}
		return new ArrayList<Contact>(contacts);
	}
	//		Session session=null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//			Contact c = new Contact(); 
	//			c.setFirstName(firstname);
	//
	//			contacts = session.createCriteria(Contact.class).add( Example.create(c) ).list();
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//		}




	//ok
	/**
	 * Renvoit la liste des contacts correspondant au nom lastname
	 * @param lastname
	 * @return
	 */
	public ArrayList<Contact> getContactByLastName(String lastname){

		List<Contact> contacts = new ArrayList<Contact>();
		try{
			contacts = getHibernateTemplate().find("from Contact as c where c.lastName = '"+lastname+"'");
		}catch(Exception e){
			return null;
		}
		return new ArrayList<Contact>(contacts);
	}
	//		Session session=null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//			Query q =session.createQuery("from Contact as c where c.lastName = '"+lastname+"'");
	//			contacts = q.list();
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//		}



	//ok
	/**
	 * Renvoit la liste des contacts correspondant a l'email email
	 * @param email
	 * @return
	 */
	public ArrayList<Contact> getContactByEmail(String email){
		List<Contact> contacts = new ArrayList<Contact>();
		try{
			contacts = getHibernateTemplate().find("from Contact as c where c.email = '"+email+"'");
		}catch(Exception e){
			return null;
		}
		return new ArrayList<Contact>(contacts);
	}
	//		Session session=null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//			Query q =session.createQuery("from Contact as c where c.email = '"+email+"'");
	//			contacts = q.list();
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//		}



	//ok
	public ArrayList<Contact> getAllContact() {
		List<Contact> contacts = new ArrayList<Contact>();
		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			// Requete HQL
			Query q =session.createQuery("from Contact" );
			contacts = q.list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		return new ArrayList<Contact>(contacts);
	}


	//ok
	public Contact addContact(Contact c) {
		try{
			getHibernateTemplate().save(c);
		}catch(Exception e){
			return null;
		}
		return c;

	}



	//A Modifier
	public boolean addFriend(Contact online, Contact friend) {
		online.getFriends().add(friend);
		try{
			getHibernateTemplate().update(friend);
			getHibernateTemplate().update(online);
		}catch(Exception e){
			System.out.println("[ERROR] : pb ajout d'ami "+e.getMessage());
			return false;
		}
		return true;

		//		Session session = null;
		//
		//		try{
		//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//			session = sessionFactory.openSession(); 
		//			org.hibernate.Transaction tx = session.beginTransaction();
		//
		//			online.getFriends().add(friend);
		//
		//			session.update(friend);
		//			session.update(online);
		//
		//			tx.commit();
		//			session.close();
		//		} 
		//		catch(Exception e){
		//			System.out.println(e.getMessage());
		//			return false;
		//		}
		//		return true;
	}

	//Ok
	public boolean deleteFriend(Contact online, Contact friend){
		Iterator<Contact> iterator = online.getFriends().iterator();
		while (iterator.hasNext()) {
			Contact ami = iterator.next();
			if (ami.getId()==friend.getId()) {
				iterator.remove();
			}
		}
		try{
			getHibernateTemplate().update(online);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//		Session session = null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//			Iterator<Contact> iterator = online.getFriends().iterator();
	//			while (iterator.hasNext()) {
	//				Contact ami = iterator.next();
	//				if (ami.getId()==friend.getId()) {
	//					iterator.remove();
	//				}
	//			}
	//			session.update(online);
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//			return false;
	//		}
	//		return true;
	//	}

	//A utiliser si on ajoute des images
	@Override
	public boolean modifyPicture(Contact online, String pathPic) {
		Session session = null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			online.setImagePerso(pathPic);

			session.update(online);
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	//OK
	@Override
	public boolean update(Contact online) {
		try{
			getHibernateTemplate().update(online);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//		Session session = null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//
	//			session.saveOrUpdate(online);
	//
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//			return false;
	//		}
	//		return true;
	//	}

	//OK
	@Override
	public boolean deletePhone(Contact online,long id) {
		Iterator<PhoneNumber> iterator = online.getPhones().iterator();
		while (iterator.hasNext()) {
			PhoneNumber num = iterator.next();
			if (num.getId()==id) {
				iterator.remove();
				try{
					getHibernateTemplate().delete(num);
				}catch(Exception e){
					return false;
				}
			}
		}
		return true;
	}


	//		Session session = null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//			Iterator<PhoneNumber> iterator = online.getPhones().iterator();
	//			while (iterator.hasNext()) {
	//				PhoneNumber num = iterator.next();
	//				if (num.getId()==id) {
	//					iterator.remove();
	//					session.delete(num);
	//				}
	//			}
	//
	//			session.update(online);
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//			return false;
	//		}
	//		return true;
	//	}



}
