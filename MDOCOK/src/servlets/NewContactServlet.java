package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Address;
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
		String phoneNumber = request.getParameter("phoneNumber");
		String type = request.getParameter("type");
		String groupName = request.getParameter("groupName");
		
		Address add = daoAddress.addAddress(city, country, street, zip);
		PhoneNumber num = daoPhoneNumber.addPhoneNumber(type, phoneNumber);
		ContactGroup cg = daoContactGroup.addContactGroup(groupName);
		
		Set<ContactGroup> lgroup= new HashSet<ContactGroup>();
		lgroup.add(cg);
		
		Set<PhoneNumber> lphones = new HashSet<PhoneNumber>();
		lphones.add(num);
		
		daoContact.addContact(prenom, nom, email, add, lgroup, lphones);
		
		
//		dao.addContact(Long.parseLong(request.getParameter("id"))
//				, request.getParameter("prenom"), request.getParameter("nom"),
//				request.getParameter("email"));
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
