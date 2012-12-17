package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Contact;
import domain.DAOContact;
import domain.IDAOContact;

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
		IDAOContact dao = new DAOContact();
		ArrayList<Contact> lcontact = new ArrayList<Contact>();
		Contact c;
		String t = request.getParameter("type");
		
			lcontact.addAll(dao.getContactByLastName(request.getParameter("search")));
		
			lcontact.addAll( dao.getContactByFirstName(request.getParameter("search")));
		
		
			lcontact.addAll( dao.getContactByEmail(request.getParameter("search")));
		
		request.setAttribute("liste", lcontact);
		request.getRequestDispatcher("findContact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
