package fr.lib.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.koor.library.business.ArticalLivre;

/**
 * Servlet implementation class ViewLivres
 */
@WebServlet("/viewLivres")
public class ViewLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/savants.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		ArticalLivre articalLivre = (ArticalLivre) session.getAttribute("articalLivre");
		if (request.getParameter("btnPrevious") != null) {
			articalLivre.getPrevious();

		}
		if (request.getParameter("btnNext") != null) {

			articalLivre.getNext();
		}
		if (request.getParameter("ajoutPanier") != null) {
			articalLivre.addCurrentLivre();
		}

		// System.out.println("**********: "+articalLivre.getLivresById().getLivres());
		request.getRequestDispatcher("/savants.jsp").forward(request, response);

	}

}
