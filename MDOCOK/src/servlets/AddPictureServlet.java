package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import dao.IDAOContact;
import dao.IDAOContactGroup;
import domain.Contact;

/**
 * Servlet implementation class AddPictureServlet
 */
public class AddPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPictureServlet() {
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
		String imagePath = c.getImagePerso();
		
		File f = new File(".");
		System.out.println("Path de la servlet : "+f.getCanonicalPath());
		System.out.println("Address Servlet"+this.getClass().getProtectionDomain().getCodeSource().getLocation());
		
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//
//		if (isMultipart) {
//			FileItemFactory factory = new DiskFileItemFactory();
//			ServletFileUpload upload = new ServletFileUpload(factory);
//
//			try {
//				List items = upload.parseRequest(request);
//				Iterator iterator = items.iterator();
//				while (iterator.hasNext()) {
//					FileItem item = (FileItem) iterator.next();
//
//					if (!item.isFormField()) {
//						String fileName = item.getName();
//
//						//String root = getServletContext().getRealPath("/");
//						File path = new File("/images_perso");
//						if (!path.exists()) {
//							boolean status = path.mkdirs();
//						}
//
//						File uploadedFile = new File(path + "/" + fileName);
//						System.out.println(uploadedFile.getName());
//						imagePath=uploadedFile.getName();
//						item.write(uploadedFile);
//					}
//				}
//			} catch (FileUploadException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		daoContact.modifyPicture(c, imagePath);
		
		response.sendRedirect("MyProfileServlet");
	}



}
