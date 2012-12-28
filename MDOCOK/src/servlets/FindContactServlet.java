package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.DAOContact;
import dao.IDAOContact;
import dao.IDAOContactGroup;
import domain.Contact;

/**
 * Servlet implementation class FindContactByIDServlet
 */
public class FindContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ICI On va mettre des requetes Example
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact dao = (IDAOContact)context.getBean("daoContact");

		Set<Contact> lcontact = new HashSet<Contact>();
		Contact c;
		String t = request.getParameter("type");

		lcontact.addAll(dao.getContactByLastName(request.getParameter("search")));
		lcontact.addAll( dao.getContactByFirstName(request.getParameter("search")));
		lcontact.addAll( dao.getContactByEmail(request.getParameter("search")));

		long idOnline = (Long) request.getSession().getAttribute("id");
		
		ArrayList<Contact> retour = enleverOnline(lcontact, idOnline);
		request.setAttribute("liste", retour);
		request.getRequestDispatcher("findContact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * Enleve les doublons dans la liste et la personne connectée
	 * @return
	 */
	public ArrayList<Contact> enleverOnline(Set<Contact> lc, long idOnline){
		ArrayList<Contact> result = new ArrayList<Contact>();
		for(Contact c : lc){
			if(!(c.getId()== idOnline ))
				result.add(c);
		}
		return result;
	}

}
