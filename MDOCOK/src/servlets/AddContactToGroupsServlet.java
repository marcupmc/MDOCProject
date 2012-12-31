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
 * Servlet implementation class AddContactToGroupsServlet
 */
public class AddContactToGroupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactToGroupsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContactGroup daoContactGroup = (IDAOContactGroup)context.getBean("daoContactGroup");
		IDAOContact daoContact = (IDAOContact)context.getBean("daoContact");
		
		//On recupere le contact a ajouter
		Contact c = daoContact.getContact(Long.parseLong(request.getParameter("idFriend").toString()));
		
		//on recupere le nombre de groupes affiché
				int nbGroupes = Integer.parseInt(request.getParameter("nb").toString());
				
				//Pour chaque champs checkbox, on verifie si la variable existe
				// si oui, ca veut dire que le champs est coché
				for(int i = 0; i<nbGroupes;i++){
					if(!(request.getParameter(""+i)==null)){
						long idG =Long.parseLong(request.getParameter("G"+i));
						ContactGroup g = daoContactGroup.getContactGroup(idG);
						daoContactGroup.addContactToGroup(g, c);
					}
				}
				request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
