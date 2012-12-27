package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import tools.HibernateUtil;


public class DAOContact implements IDAOContact{

	/**
	 * Rajoute un contact dans la base de donnees.
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return renvoit le nouveau contact
	 */
	public Contact addContact(String firstname, String lastname, String email,Address add, Set<ContactGroup> groupes, Set<PhoneNumber> phones){

		Contact contact=null;
		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			contact = new Contact();
			contact.setAdd(add);
			contact.setEmail(email);
			contact.setFirstName(firstname);
			contact.setLastName(lastname);
			contact.setBooks(groupes);
			contact.setPhones(phones);

			session.save(contact);
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		//return contact;
		return contact;
	}

	/**
	 * Suppresion d'un contact a partir de son identifiant
	 * @param id
	 * @return vrai si la suppression a bien ete effectuee
	 */
	public int deleteContact(long id){
		int success=0;
		Connection con = null;
		try{
			Class.forName(Messages.getString("driver")); 
			con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"), Messages.getString("password")); 
			Statement stmt = con.createStatement();
			String request = "DELETE FROM contacts WHERE id = "+id; 
			success = stmt.executeUpdate(request);
			stmt.close();
			con.close();

		} catch( Exception e ){
			e.printStackTrace();
		}

		return success;
	}

	/**
	 * Recuperation d'un contact a partir de son identifiant
	 * @param id
	 * @return
	 */
	public Contact getContact(long id){

		List<Contact> contacts = new ArrayList<Contact>();

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			Query q =session.createQuery("from Contact as c where c.id = '"+id+"'");
			contacts = q.list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		return new ArrayList<Contact>(contacts).get(0);
	}

	/**
	 * Methode qui modifie les coordonees d'un contact
	 * @param id
	 * @param firstname
	 * @param alstname
	 * @param email
	 * @return
	 */
	public boolean modifyContact(long id, String firstname, String lastname, String email,
			Address add, Set<ContactGroup> books, Set<PhoneNumber> phones){
		Contact toModify = this.getContact(id);

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			toModify.setAdd(add);
			toModify.setBooks(books);
			toModify.setEmail(email);
			toModify.setLastName(lastname);
			toModify.setFirstName(firstname);
			toModify.setPhones(phones);

			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Renvoit la liste des contacts correspondant au prenom firrstname
	 * @param firstname
	 * @return
	 */
	public ArrayList<Contact> getContactByFirstName(String firstname){

		List<Contact> contacts = new ArrayList<Contact>();

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();
			// Requete par Exemple
			Query q =session.createQuery("from Contact as c where c.firstName = '"+firstname+"'");
			contacts = q.list();
			Contact c = new Contact(); 
			c.setFirstName(firstname);

			contacts = session.createCriteria(Contact.class).add( Example.create(c) ).list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		return new ArrayList<Contact>(contacts);
	}

	/**
	 * Renvoit la liste des contacts correspondant au prenom firrstname
	 * @param firstname
	 * @return
	 */
	public Contact getContactById(long id){

		List<Contact> contacts = new ArrayList<Contact>();

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			Query q =session.createQuery("from Contact as c where c.id = '"+id+"'");
			contacts = q.list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		return new ArrayList<Contact>(contacts).get(0);
	}


	/**
	 * Renvoit la liste des contacts correspondant au nom lastname
	 * @param lastname
	 * @return
	 */
	public ArrayList<Contact> getContactByLastName(String lastname){

		List<Contact> contacts = new ArrayList<Contact>();

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			Query q =session.createQuery("from Contact as c where c.lastName = '"+lastname+"'");
			contacts = q.list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		return new ArrayList<Contact>(contacts);
	}

	/**
	 * Renvoit la liste des contacts correspondant a l'email email
	 * @param email
	 * @return
	 */
	public ArrayList<Contact> getContactByEmail(String email){
		List<Contact> contacts = new ArrayList<Contact>();

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			Query q =session.createQuery("from Contact as c where c.email = '"+email+"'");
			contacts = q.list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		return new ArrayList<Contact>(contacts);
	}

	@Override
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

	@Override
	public Contact addContact(Contact c) {
		Session session = null;

		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			Set<PhoneNumber> ln =  c.getPhones();
			for(PhoneNumber num : ln){
				num.setContact(c);
			}


			//			Set<ContactGroup> groupes = c.getBooks();
			//			for(ContactGroup g : groupes){
			//				g.getContacts().add(c);
			//			}

			session.save(c);
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return c;
	}

	/**
	 * 
	 */
	public boolean addFriend(Contact online, Contact friend) {
		Session session = null;

		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			Set<Contact> myfriends = online.getFriends();
			myfriends.add(friend);
			online.setFriends(myfriends);

			session.save(online);
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
