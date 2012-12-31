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
 * Servlet implementation class NewContactGroupServlet
 */
public class NewContactGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewContactGroupServlet() {
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
		
		IDAOContactGroup dao = (IDAOContactGroup)context.getBean("daoContactGroup");
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		
		long idOnline = Long.parseLong(request.getSession().getAttribute("id").toString());
		
		String name = request.getParameter("name");
		ContactGroup g = dao.addContactGroup(name,idOnline);
		
		ArrayList<ContactGroup> lgroupes = new ArrayList<ContactGroup>(dao.getContactGroupByOwner(idOnline));
		
		request.setAttribute("liste", lgroupes);
		
		request.getRequestDispatcher("contactGroups.jsp").forward(request, response);
		
	}

}
