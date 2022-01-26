package presentation;

import metier.Bibliotheque;
import metier.Frequence;

public class Principale {

	public static void main(String[] args) {

		Bibliotheque bib = new Bibliotheque("BibNour");

		bib.ajouterDocument("Sahih mouslim", 450, "Mouslim");
		bib.ajouterDocument("Boulough Al Maram", 1235, "Ibn Hajar");
		bib.ajouterDocument("Ibn Kathir exegese", 2365, "Ibn Kathir");
		bib.ajouterDocument("Islah", 2365, Frequence.MENSEUL);

		bib.getCompteur();
		for (int j = 0; j < bib.getCompteur(); j++) {
			System.out.println(bib.getAt(j).affiche());
		}

	}

}
