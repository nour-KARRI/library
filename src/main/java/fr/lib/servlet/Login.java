package fr.lib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.koor.library.dao.DAOContext;

/**
 * Servlet implementation class Demo
 */
@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HttpSession session;
	
	@Override
		public void init() throws ServletException {
		//	DAOContext.init(getServletContext());
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Demo", "A Value");
		
		String login = request.getParameter( "txtLogin" );
		String email = request.getParameter( "txtEmail" );
        String password = request.getParameter( "txtPassword" );
      
        if ( login == null ) login = "";
        if ( password == null ) password = "";
        
		session= request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		
	
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("do POST");
		
		String login = request.getParameter( "txtLogin" );
		String email = request.getParameter( "txtEmail" );
        String password = request.getParameter( "txtPassword" );
        session.setAttribute("login", login);
        session.setAttribute("email", email);
		session.setAttribute("password", password);
      
       
        
        if ( login.equals( "bond" ) && password.equals( "007" ) ) {
        	request.getRequestDispatcher("/savants.jsp").forward(request, response);
        	session.setAttribute("isConnected", true);
        }else {
        	request.getRequestDispatcher("/login.jsp").forward(request, response);
        	session.setAttribute("isConnected", false);
        }
	}

}
