package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.IDAOContact;
import dao.IDAOPhoneNumber;
import domain.Contact;
import domain.PhoneNumber;

/**
 * Servlet implementation class AddNewPhoneServlet
 */
public class AddNewPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewPhoneServlet() {
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
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		
		long idOnline = Long.parseLong(request.getSession().getAttribute("id").toString());
		
		Contact c = daoContact.getContact(idOnline);
		
		String num = request.getParameter("phone");
		String type = request.getParameter("type");
		
		PhoneNumber p = new PhoneNumber();
		//PhoneNumber p = (PhoneNumber)context.getBean("phonenumber_default");
		p.setPhoneNumber(num);
		p.setPhoneKind(type);
		p.setContact(c);
		
		c.getPhones().add(p);
		
		daoContact.update(c);
		
		response.sendRedirect("MyProfileServlet");
	}

}
