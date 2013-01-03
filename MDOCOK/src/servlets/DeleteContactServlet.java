package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
import domain.ContactGroup;

/**
 * Servlet implementation class DeleteContactServlet
 */
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		IDAOContactGroup daoContactGroup = (IDAOContactGroup)context.getBean("daoContactGroup");
		
		long idFriend = Long.parseLong(request.getParameter("id"));
		long idOnline = Long.parseLong(request.getSession().getAttribute("id").toString());
		
		Contact friend = daoContact.getContact(idFriend);
		Contact online = daoContact.getContact(idOnline);
		
		//on supprime le contact de tout les groupes de online où il est present
		ArrayList<ContactGroup> mesgroupes = daoContactGroup.getContactGroupByOwner(idOnline);	
		for(ContactGroup g : mesgroupes){
			for(Contact c : g.getContacts()){
				if(c.getId()==idFriend){
					daoContactGroup.removeContact(g, c);
				}
			}
				
		}
		daoContact.deleteFriend(online, friend);
		response.sendRedirect("PrintAllContactsServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
