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
import dao.DAOContact;
import dao.DAOContactGroup;
import dao.DAOPhoneNumber;
import dao.IDAOAddress;
import dao.IDAOContact;
import dao.IDAOContactGroup;
import dao.IDAOPhoneNumber;
import domain.Address;
import domain.ContactGroup;
import domain.PhoneNumber;

/**
 * Servlet implementation class UpdateContactServlet
 */
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		IDAOAddress daoAddress = (IDAOAddress)context.getBean("daoAddress");
		IDAOPhoneNumber daoPhoneNumber = (IDAOPhoneNumber)context.getBean("daoPhoneNumber");
		IDAOContactGroup daoContactGroup = (IDAOContactGroup)context.getBean("daoContactGroup");
		
		//Recuperation des données formulaire
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String zip = request.getParameter("zip");
//		String phoneNumber = request.getParameter("phoneNumber");
//		String type = request.getParameter("type");
//		String groupName = request.getParameter("groupName");
//		long idGroup = Long.parseLong(request.getParameter("idGroup"));
		long idContact = Long.parseLong(request.getParameter("id"));
		long idAddress  = Long.parseLong(request.getParameter("idAddress"));
//		long idPhone = Long.parseLong(request.getParameter("idPhone"));
		

		//Modification de Address, PhoneNumber et ContactGroup
		daoAddress.modifyAddress(idAddress, city, country, street, zip);
//		daoPhoneNumber.modifyPhoneNumber(idPhone,type, phoneNumber);
//		daoContactGroup.modifyContactGroup(idGroup,groupName);
		
		//Set des parametre de modifyContact
//		Set<ContactGroup> lgroup= new HashSet<ContactGroup>();
//		lgroup.add(daoContactGroup.getContactGroup(idGroup));
//		Set<PhoneNumber> lphones = new HashSet<PhoneNumber>();
//		lphones.add(daoPhoneNumber.getPhoneNumber(idPhone));
//		Address add = daoAddress.getAddress(idAddress);
		
		daoContact.modifyContact(idContact, prenom, nom,email);
		
		request.getRequestDispatcher("MyProfileServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
