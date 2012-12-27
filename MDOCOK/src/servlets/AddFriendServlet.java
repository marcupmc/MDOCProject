package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import domain.Contact;
import domain.IDAOContact;

/**
 * Servlet implementation class AddFriendServlet
 */
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		long idFriend = Long.parseLong(request.getParameter("id"));
		long idOnline = Long.parseLong(request.getSession().getAttribute("id").toString());
		System.out.println("Id du contact en ligne "+idOnline);
		
		Contact friend = daoContact.getContact(idFriend);
		Contact online = daoContact.getContact(idOnline);
		daoContact.addFriend(online, friend);
		
		request.getRequestDispatcher("PrintAllContactsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
