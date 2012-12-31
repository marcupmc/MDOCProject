package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.IDAOContactGroup;
import domain.ContactGroup;

/**
 * Servlet implementation class RenameGroupServlet
 */
public class RenameGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenameGroupServlet() {
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
		// TODO Auto-generated method stub
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IDAOContactGroup daoContactGroup = (IDAOContactGroup)context.getBean("daoContactGroup");
		ContactGroup groupe = daoContactGroup.getContactGroup(Long.parseLong(request.getParameter("groupeId")));
		
		String newname = request.getParameter("name");
		
		daoContactGroup.modifyContactGroup(groupe.getGroupId(), newname);
		response.sendRedirect("ManageContactGroupServlet?id="+groupe.getGroupId());
		
	}

}
