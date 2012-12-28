package servlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tools.CryptoTool;

import dao.IDAOContact;
import domain.Address;
import domain.Contact;
import domain.PhoneNumber;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
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
		// TODO Auto-generated method stub
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		String firstname =  request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String zip = request.getParameter("zip");
		String phoneNumber = request.getParameter("phoneNumber0");
		String typePhone = request.getParameter("type");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
			
		if(!password.equals(repassword)){
			
			request.setAttribute("password", true);
		}else if(daoContact.getContactByEmail(email).size()>0){
			request.setAttribute("password", true);
		}
		else{
			//ici on ajoute le contact à la base !
			
			
			PhoneNumber num = new PhoneNumber();
			num.setPhoneKind(typePhone);
			num.setPhoneNumber(phoneNumber);
			Address add = new Address();
			
			add.setCity(city);
			add.setCountry(country);
			add.setStreet(street);
			add.setZip(zip);
			
			Set<PhoneNumber> lphones = new HashSet<PhoneNumber>();
			lphones.add(num);
		
			Contact c=new Contact();
			c.setAdd(add);
			c.setFirstName(firstname);
			c.setLastName(lastname);
			c.setEmail(email);
			c.setPhones(lphones);
			try {
				c.setPassword(CryptoTool.getEncodedPassword(password));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			daoContact.addContact(c);
			request.setAttribute("signok", true);
			request.setAttribute(password, false);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	

}
