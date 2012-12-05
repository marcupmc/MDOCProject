package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tools.HibernateUtil;

public class DAOContactGroup implements IDAOContactGroup {

	@Override
	public ContactGroup addContactGroup(String groupName) {
		ContactGroup group = null;
		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			group = new ContactGroup();
			group.setGroupName(groupName);
			
			session.save(group);
			tx.commit();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return group;
	}

	@Override
	public ContactGroup getContactGroup(long id) {
		List<ContactGroup> groupe = new ArrayList<ContactGroup>();

		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();
						
			Query q =session.createQuery("from ContactGroup as c where c.groupId = '"+id+"'");
			groupe = q.list();
			tx.commit();
			session.close();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return new ArrayList<ContactGroup>(groupe).get(0);
	}

	@Override
	public boolean modifyContactGroup(long id, String groupename) {
		ContactGroup groupe = this.getContactGroup(id);
	
		Session session=null;
		try{
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession(); 
			org.hibernate.Transaction tx = session.beginTransaction();

			groupe.setGroupName(groupename);
			
			session.save(groupe);
			tx.commit();
		} 
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
		
	}

}
