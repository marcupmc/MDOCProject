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
import dao.IDAOContactGroup;
import domain.Contact;
import domain.ContactGroup;

/**
 * Servlet implementation class AvailableGroups
 */
public class AvailableGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableGroups() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Pour l'id de la personne récupérée, on montre tout les groupes de online où elle n'apparait pas

		//On recupere tout les groupes de l'utilisateur connecté
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContactGroup daoContactGroup = (IDAOContactGroup)context.getBean("daoContactGroup");
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		
		
		long idOnline = Long.parseLong(request.getSession().getAttribute("id").toString());
		ArrayList<ContactGroup> lgroupes = new ArrayList<ContactGroup>(daoContactGroup.getContactGroupByOwner(idOnline));
		
		// On met dans groupesAvailable tout les groupes dans lequel n'apparait pas idFriend
		boolean trouve = false;
		long idFriend =  Long.parseLong(request.getParameter("idFriend").toString());
		Contact contact = daoContact.getContact(idFriend);
		
		ArrayList<ContactGroup> groupesAvailable = new ArrayList<ContactGroup>();
		for(ContactGroup g : lgroupes){
			for(Contact c : g.getContacts()){
				if(c.getId()==idFriend)
					trouve=true;
			}
			if(!trouve){
				groupesAvailable.add(g);
			}
			trouve=false;
		}
		
		request.setAttribute("firstname", contact.getFirstName());
		request.setAttribute("lastname", contact.getLastName());
		request.setAttribute("liste", groupesAvailable);
		request.setAttribute("idFriend", idFriend);
		request.getRequestDispatcher("addToGroups.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
