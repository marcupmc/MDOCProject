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
 * Servlet implementation class ManageContactGroupServlet
 */
public class ManageContactGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageContactGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContactGroup daoContactGroup = (IDAOContactGroup)context.getBean("daoContactGroup");
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		
		ArrayList<Contact> toSend = new ArrayList<Contact>();
		
		long idOnline = Long.parseLong(request.getSession().getAttribute("id").toString());
		Contact c = daoContact.getContact(idOnline);
		
		long idgroupe = Long.parseLong(request.getParameter("id"));
		ContactGroup g = daoContactGroup.getContactGroup(idgroupe);
		
		boolean trouve = false;
		for(Contact amis : c.getFriends()){
			for(Contact ingroup : g.getContacts()){
				if(ingroup.getId()==amis.getId())
					trouve=true;
			}
			if(!trouve)
				toSend.add(amis);
			trouve=false;
		}
		request.setAttribute("friends", toSend);
		request.setAttribute("groupe", g);
		request.getRequestDispatcher("manageGroup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
