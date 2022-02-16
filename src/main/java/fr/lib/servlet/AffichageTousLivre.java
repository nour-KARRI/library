package fr.lib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.koor.library.business.Oeuvres;
import fr.koor.library.dao.SavantsDAO;

/**
 * Servlet implementation class AffichageTousLivre
 */
@WebServlet("/affichageTousLivre")
public class AffichageTousLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SavantsDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		session.setAttribute("tousLesSavantsKKK", false);
		session.setAttribute("tousLesLivres", false);
		session.setAttribute("domaines", false);
		request.getRequestDispatcher("/savants.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		dao = new SavantsDAO();

		HttpSession session = request.getSession(true);

		if (request.getParameter("dropDown") != null) {
			session.setAttribute("dropDown", true);
		}

		// recuprer l'idSavant envoyer par la JSP
		String id = request.getParameter("isSavant");

		dao = new SavantsDAO();
		int savantId = Integer.parseInt(id);
		// recuperer tous les livres du sheikh
		List<Oeuvres> listLivres = dao.getListLivres(savantId);
		request.setAttribute("listLivres", listLivres);

		// recuperer le nom du sheikh
		String nom = dao.getNomSavant(savantId);
		request.setAttribute("nom", nom);
		// if (id !=null) {}
		request.getRequestDispatcher("/savants.jsp").forward(request, response);

	}

}
