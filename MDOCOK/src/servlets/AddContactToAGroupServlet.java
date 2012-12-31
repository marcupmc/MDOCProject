package servlets;

import java.io.IOException;
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
 * Servlet implementation class AddContactToAGroupServlet
 */
public class AddContactToAGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContactToAGroupServlet() {
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
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContactGroup daoContactGroup = (IDAOContactGroup)context.getBean("daoContactGroup");
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");

		ContactGroup group = daoContactGroup.getContactGroup(Long.parseLong(request.getParameter("groupeId")));
		int nbFriend = Integer.parseInt(request.getParameter("nbFriend").toString());

		for(int i = 0; i<nbFriend;i++){
			if(!(request.getParameter(""+i)==null)){
				long idF =Long.parseLong(request.getParameter("F"+i));
				Contact c = daoContact.getContact(idF);
				daoContactGroup.addContactToGroup(group, c);
			}
		}
		
		response.sendRedirect("ManageContactGroupServlet?id="+group.getGroupId());
	}

}
