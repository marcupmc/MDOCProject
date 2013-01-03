package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.DAOAddress;
import dao.DAOContactGroup;
import dao.DAOPhoneNumber;
import dao.IDAOAddress;
import dao.IDAOContact;
import dao.IDAOContactGroup;
import dao.IDAOPhoneNumber;
import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.PhoneNumber;

/**
 * Servlet implementation class NewContactServlet
 */
public class NewContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		
		//JUSTE Un petit test pour ce qu'il y a dans le applicationContext
		Contact contBean = (Contact)context.getBean("contact");
		
		
		
		IDAOAddress daoAddress = new DAOAddress();
		IDAOPhoneNumber daoPhoneNumber = new DAOPhoneNumber();
		IDAOContactGroup daoContactGroup = new DAOContactGroup();
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String zip = request.getParameter("zip");
		String phoneNumber = request.getParameter("phoneNumber0");
		String type = request.getParameter("type");
		String groupName = request.getParameter("groupName0");
		
		//Address add = daoAddress.addAddress(city, country, street, zip);
		PhoneNumber num = new PhoneNumber();//daoPhoneNumber.addPhoneNumber(type, phoneNumber);
		
		ContactGroup cg = new ContactGroup();//daoContactGroup.addContactGroup(groupName);
		cg.setGroupName(groupName);
		Set<ContactGroup> lgroup= new HashSet<ContactGroup>();
		lgroup.add(cg);
		
		Address add = new Address();
		
		add.setCity(city);
		add.setCountry(country);
		add.setStreet(street);
		add.setZip(zip);
		
		num.setPhoneKind(type);
		num.setPhoneNumber(phoneNumber);
		
		Set<PhoneNumber> lphones = new HashSet<PhoneNumber>();
		lphones.add(num);
		
		
		Contact c=new Contact();
		c.setAdd(add);
		c.setFirstName(prenom);
		c.setLastName(nom);
		c.setEmail(email);
		c.setPhones(lphones);
		c.setBooks(lgroup);
		
		
		//num.setContact(c);
		daoContact.addContact(c); 
		
		//Ajout des beans
		daoContact.addContact(contBean);
		
		
		//daoPhoneNumber.addPhoneNumber(num);

//		dao.addContact(Long.parseLong(request.getParameter("id"))
//				, request.getParameter("prenom"), request.getParameter("nom"),
//				request.getParameter("email"));
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
