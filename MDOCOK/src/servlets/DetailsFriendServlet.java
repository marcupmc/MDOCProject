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
 * Servlet implementation class DetailsFriendServlet
 */
public class DetailsFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsFriendServlet() {
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
		
		Contact c = daoContact.getContact(Long.parseLong(request.getParameter("id")));
		ArrayList<ContactGroup> lgroupes = new ArrayList<ContactGroup>(daoContactGroup.getContactGroupByOwner(c.getId()));
		
		request.setAttribute("liste", lgroupes);
		request.setAttribute("contact", c);
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
