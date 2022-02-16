package fr.lib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.koor.library.business.ArticalLivre;
import fr.koor.library.business.Savants;
import fr.koor.library.dao.DAOContext;
import fr.koor.library.dao.SavantsDAO;

/**
 * Servlet implementation class ListSavants
 */
@WebServlet(urlPatterns = "/listSavants", loadOnStartup = 1)
public class ListSavants extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		DAOContext.init(this.getServletContext());
	}

	SavantsDAO dao;
	Savants savant;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		session.setAttribute("articalLivre", new ArticalLivre());
		session.setAttribute("tousLesSavantsKKK", false);
		session.setAttribute("tousLesLivres", false);
		session.setAttribute("domaines", false);
		request.getRequestDispatcher("/savants.jsp").forward(request, response);
	}

	private void listSavants(HttpServletRequest request, HttpServletResponse response) {
		dao = new SavantsDAO();
		System.out.println("do get");

		try {
			List<Savants> listSavants = dao.getListSavants();
			request.setAttribute("listSavants", listSavants);
			request.getRequestDispatcher("/savants.jsp").forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		dao = new SavantsDAO();
		System.out.println("do Post ListSavant");
		HttpSession session = request.getSession(true);
		session.setAttribute("dropDown", false);

		if (request.getParameter("tousLesSavants") != null) {
			List<Savants> listSavants = dao.getListSavants();
			session.setAttribute("listSavants", listSavants);
			session.setAttribute("tousLesLivres", false);
			session.setAttribute("tousLesSavants", true);
		}

		if (request.getParameter("tousLesLivres") != null) {
			session.setAttribute("tousLesSavants", false);
			session.setAttribute("tousLesLivres", true);
			session.setAttribute("articalLivre", new ArticalLivre());
		}
		if (request.getParameter("domaines") != null) {
			session.setAttribute("tousLesSavants", false);
			session.setAttribute("tousLesLivres", false);
			session.setAttribute("domaines", true);
		}

		request.getRequestDispatcher("/savants.jsp").forward(request, response);

		// Inert Image in DB

		// dao.InertImage();
		// System.out.println("Record inserted......");

	}

}
