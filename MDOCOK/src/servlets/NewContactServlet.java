package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.DAOAddress;
import domain.DAOContact;
import domain.DAOContactGroup;
import domain.DAOPhoneNumber;
import domain.IDAOAddress;
import domain.IDAOContact;
import domain.IDAOContactGroup;
import domain.IDAOPhoneNumber;
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
		IDAOContact daoContact = new DAOContact();
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
		//ContactGroup cg = daoContactGroup.addContactGroup(groupName);
		
		//Set<ContactGroup> lgroup= new HashSet<ContactGroup>();
		//lgroup.add(cg);
		
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
		//c.setBooks(lgroup);
		

		daoContact.addContact(c);
		
		
//		dao.addContact(Long.parseLong(request.getParameter("id"))
//				, request.getParameter("prenom"), request.getParameter("nom"),
//				request.getParameter("email"));
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
