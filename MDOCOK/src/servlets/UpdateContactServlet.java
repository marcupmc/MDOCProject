package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.IDAOContact;
import domain.Contact;
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
		
		//Recuperation des données formulaire
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String zip = request.getParameter("zip");
		int nbTel = Integer.parseInt(request.getParameter("nbTel"));
		
		long idContact = Long.parseLong(request.getParameter("id"));
		
		Contact c = daoContact.getContact(idContact);
		c.setFirstName(prenom);
		c.setLastName(nom);
		c.setEmail(email);
		c.getAdd().setCity(city);
		c.getAdd().setCountry(country);
		c.getAdd().setStreet(street);
		c.getAdd().setZip(zip);
		
		ArrayList<PhoneNumber> nums = new ArrayList<PhoneNumber>(c.getPhones());
		for(int i = 0; i <nbTel;i++){
			nums.get(i).setPhoneNumber(request.getParameter("tel"+i));
		}
		
		daoContact.update(c);
		
		request.getRequestDispatcher("MyProfileServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
