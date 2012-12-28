package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOContactGroup;
import dao.IDAOContactGroup;
import domain.ContactGroup;

/**
 * Servlet implementation class FindContactGroupServlet
 */
public class FindContactGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindContactGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		System.out.println("Requete = "+search);
		IDAOContactGroup dao = new DAOContactGroup();
		
		ArrayList<ContactGroup> groupes = new ArrayList<ContactGroup>();
		groupes = dao.getContactGroups(search);
		System.out.println("Requete = "+search+"  etGroupes trouvés "+groupes.size());
		request.setAttribute("liste", groupes);
		request.getRequestDispatcher("contactGroups.jsp").forward(request, response);
	
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		}

}
