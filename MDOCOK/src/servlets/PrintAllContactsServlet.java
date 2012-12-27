package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import domain.Contact;
import domain.ContactGroup;
import domain.DAOContact;
import domain.DAOContactGroup;
import domain.IDAOContact;
import domain.IDAOContactGroup;

/**
 * Servlet implementation class PrintAllContactsServlet
 */
public class PrintAllContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintAllContactsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContactGroup daoG = (IDAOContactGroup)context.getBean("daoContactGroup");
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");

		//On charge tout les groupes pour pouvoir ajouter les contacts a des groupes
		ArrayList<ContactGroup> lgroupes = new ArrayList<ContactGroup>();
		lgroupes = daoG.getAllContactGroups();
		request.setAttribute("listeGroupes", lgroupes);

		// On recupere tout les amis du contact en ligne 
		long idOnline = Long.parseLong(request.getSession().getAttribute("id").toString());
		Contact online = daoContact.getContact(idOnline);
		ArrayList<Contact> lcontact = new ArrayList<Contact>(online.getFriends());
		request.setAttribute("liste", lcontact);

		request.getRequestDispatcher("updateContact.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
