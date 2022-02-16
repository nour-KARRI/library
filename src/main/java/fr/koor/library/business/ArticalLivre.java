package fr.koor.library.business;

import java.util.ArrayList;
import java.util.List;

import fr.koor.library.dao.SavantsDAO;

public class ArticalLivre {

	private int currentPosition = 1;
	int countLivre = SavantsDAO.getCountLivre();
	private Oeuvres currentOeuvre;
	List<PanierLivre> panierLivre = new ArrayList<>();

	public ArticalLivre() {
		currentOeuvre = SavantsDAO.getElementbyId(currentPosition);
	}

	public Oeuvres getCurrentOeuvre() {
		return currentOeuvre;
	}

	public List<PanierLivre> getPanierLivre() {
		return panierLivre;
	}

	public int getPanierLivreSize() {
		int fullQuantity = 0;
		for (PanierLivre panierLivre : panierLivre) {
			fullQuantity += panierLivre.getQuantity();
		}

		return fullQuantity;
	}

	public void getPrevious() {
		if (--currentPosition < 1) {
			currentPosition = countLivre;
		}
		currentOeuvre = SavantsDAO.getElementbyId(currentPosition);
	}

	public void getNext() {
		if (++currentPosition > countLivre) {
			currentPosition = 1;
		}

		currentOeuvre = SavantsDAO.getElementbyId(currentPosition);
		System.out.println("currentOeuvre getNext ID=========" + currentOeuvre.getId());
	}

	public void addCurrentLivre() {

		for (PanierLivre panierLivre : panierLivre) {
			if (panierLivre.getOeuvres().getId() == currentOeuvre.getId()) {
				panierLivre.increaseQuantity();
				return;
			}
		}

		panierLivre.add(new PanierLivre(currentOeuvre, 1));
	}

}
