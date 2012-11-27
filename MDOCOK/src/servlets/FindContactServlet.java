package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Contact;
import domain.DAOContact;
import domain.IDAOContact;

/**
 * Servlet implementation class FindContactByIDServlet
 */
public class FindContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOContact dao = new DAOContact();
		//recuperer l'option selctionnée
		//faire la recherche 
		Contact c=dao.getContact(Long.parseLong(request.getParameter("id")));
		
		//passer le contact dans la requete
		request.setAttribute("", arg1)
		//redidriger à la servlet
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOContact dao = new DAOContact();
		Contact c=dao.getContact(Long.parseLong(request.getParameter("id")));
		String nom = c.getLastName();
		String prenom = c.getFirstName();
		String email = c.getEmail();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String html = "<html>" +
				"<body>" +
				"<h1> Resultat de la recherche </h1><p>"+nom+" "+prenom+ " "+email +"</p>" +
				"<p><a href=\"menu.jsp\">Return to menu</a></p></body>" +
				"</html>";
				
		out.println(html);
		out.close();
		
	}

}
