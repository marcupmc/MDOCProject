package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tools.CryptoTool;

import domain.Contact;
import domain.IDAOContact;

/**
 * Servlet implementation class HelloServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		String email = request.getParameter("emailLog");
		String password = request.getParameter("passwordLog");
		String passHash=null;
		String name = null;
		try {
			 passHash = CryptoTool.getEncodedPassword(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean ok = true;
		
		ArrayList<Contact> c = daoContact.getContactByEmail(email);
		System.out.println("taille de la liste c "+c.size());
		if(c.size()==1){
			Contact c1 = c.get(0);
			System.out.println(c1);
			System.out.println(" password2: "+passHash);
			name = c1.getFirstName();
			if(!c1.getPassword().equals(passHash)){
				ok=false;
				System.out.println("Le mot de passe n'est pas bon");
			}
		}else{
			ok=false;
		}
		
		//On renvoit vers l'acceuil ou la connexion en fonction de ok
		if(ok){
			request.getSession().setAttribute("login", name);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}else{
			request.setAttribute("failConnexion",true );
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
	}

}
