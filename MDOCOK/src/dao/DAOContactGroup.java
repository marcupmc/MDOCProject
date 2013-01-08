package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Contact;
import domain.ContactGroup;
import domain.Messages;

import tools.HibernateUtil;


public class DAOContactGroup extends HibernateDaoSupport implements IDAOContactGroup {

	private HibernateTemplate hibernateTemplate; 

	public void setHibernateTemplate(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public ContactGroup addContactGroup(String groupName,long idOwner) {
		ContactGroup group = new ContactGroup();
		group.setIdOwner(idOwner);
		group.setGroupName(groupName);
		try{
			getHibernateTemplate().save(group);
		}catch(Exception e){
			return null;
		}
		return group;
	}

		//		ContactGroup group = null;
		//		Session session=null;
		//		try{
		//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//			session = sessionFactory.openSession(); 
		//			org.hibernate.Transaction tx = session.beginTransaction();
		//
		//			group = new ContactGroup();
		//			group.setIdOwner(idOwner);
		//			group.setGroupName(groupName);
		//
		//			session.persist(group);
		//			tx.commit();
		//			session.close();
		//		} 
		//		catch(Exception e){
		//			System.out.println(e.getMessage());
		//		}
		//		return group;
	//}

	@Override
	public ContactGroup getContactGroup(long id) {
		try{
			return (ContactGroup) getHibernateTemplate().find("from ContactGroup as g where g.id =?",id).get(0);
		}catch(Exception e){
			return null;	
		}

		//		List<ContactGroup> groupe = new ArrayList<ContactGroup>();
		//
		//		Session session=null;
		//		try{
		//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//			session = sessionFactory.openSession(); 
		//			org.hibernate.Transaction tx = session.beginTransaction();
		//						
		//			Query q =session.createQuery("from ContactGroup as c where c.groupId = '"+id+"'");
		//			groupe = q.list();
		//			tx.commit();
		//			session.close();
		//		} 
		//		catch(Exception e){
		//			System.out.println(e.getMessage());
		//		}
		//		
		//		return new ArrayList<ContactGroup>(groupe).get(0);
	}

	@Override
	public boolean modifyContactGroup(long id, String groupename) {
		ContactGroup groupe = this.getContactGroup(id);
		groupe.setGroupName(groupename);
		try{
			getHibernateTemplate().update(groupe);
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
//			groupe.setGroupName(groupename);
//
//			session.update(groupe);
//			tx.commit();
//			session.close();
//		} 
//		catch(Exception e){
//			System.out.println(e.getMessage());
//			return false;
//		}
//		return true;

//	}

	// Unused
	@Override
	public ArrayList<ContactGroup> getAllContactGroups() {
		List<ContactGroup> lgroups =  new ArrayList<ContactGroup>();
		try{
			lgroups = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(ContactGroup.class));
		}catch(Exception e){
			return null;
		}
		return (ArrayList<ContactGroup>) lgroups;
		
/*		Session session = null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			// Requete HQL
			Query q =session.createQuery("from ContactGroup" );
			lgroups = q.list();
			tx.commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	

		return (ArrayList<ContactGroup>) lgroups;
		*/
		
	}

	@Override
	public ArrayList<ContactGroup> getContactGroups(String search) {
		List<ContactGroup> lgroups =  new ArrayList<ContactGroup>();
		try{
			lgroups = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(ContactGroup.class).add(Restrictions.like("groupName",search+"%")));
		}catch(Exception e){
			return null;
		}
		return (ArrayList<ContactGroup>) lgroups;
	}
	//		Session session = null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//			lgroups = session.createCriteria(ContactGroup.class) .add(Restrictions.like("groupName", search+"%") ).list();
	//			tx.commit();
	//			session.close();
	//		}catch(Exception e){
	//			System.out.println(e.getMessage());
	//		}	



	@Override
	public ArrayList<ContactGroup> getContactGroupByOwner(long id) {
		List<ContactGroup> groupe = new ArrayList<ContactGroup>();
		try{
			groupe = getHibernateTemplate().find("from ContactGroup as g where g.idOwner = '"+id+"'");
		}catch(Exception e){
			return null;
		}
		return new ArrayList<ContactGroup>(groupe);
	}
	//		Session session=null;
	//		try{
	//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//			session = sessionFactory.openSession(); 
	//			org.hibernate.Transaction tx = session.beginTransaction();
	//
	//			Query q =session.createQuery("from ContactGroup as c where c.idOwner = '"+id+"'");
	//			groupe = q.list();
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//		}



	@Override
	public boolean addContactToGroup(ContactGroup g, Contact c) {
		g.getContacts().add(c);
		try{
			getHibernateTemplate().update(g);
		}catch(Exception e){
			return false;
		}
		return true;
		//		Session session=null;
		//		try{
		//			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//			session = sessionFactory.openSession(); 
		//			org.hibernate.Transaction tx = session.beginTransaction();
		//
		//			g.getContacts().add(c);
		//			
		//			session.update(g);
		//			tx.commit();
		//			session.close();
		//		} 
		//		catch(Exception e){
		//			System.out.println(e.getMessage());
		//			return false;
		//		}
		//		return true;
	}

	@Override
	public boolean removeContact(ContactGroup groupe, Contact contact) {
		Iterator<Contact> iterator = groupe.getContacts().iterator();
		while (iterator.hasNext()) {
			Contact ami = iterator.next();
			if (ami.getId()==contact.getId()) {
				iterator.remove();
			}
		}
		try{
			getHibernateTemplate().update(groupe);
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
	//			Iterator<Contact> iterator = groupe.getContacts().iterator();
	//			while (iterator.hasNext()) {
	//				Contact ami = iterator.next();
	//				if (ami.getId()==contact.getId()) {
	//					iterator.remove();
	//				}
	//			}
	//
	//			session.update(groupe);
	//			tx.commit();
	//			session.close();
	//		} 
	//		catch(Exception e){
	//			System.out.println(e.getMessage());
	//			return false;
	//		}
	//		return true;
	//	}

	@Override
	public boolean deleteContactGroup(ContactGroup g) {
		try{
			getHibernateTemplate().delete(g);
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
	//			session.delete(g);
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
