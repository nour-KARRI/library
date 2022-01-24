package presentation;

import metier.Bibliotheque;
import metier.Type;

public class Principale {

	public static void main(String[] args) {

		Bibliotheque bib = new Bibliotheque("BibNour");

		bib.ajouterDocument("Sahih mouslim", 450, Type.LIVRE);
		bib.ajouterDocument("Boulough Al Maram", 1235, Type.LIVRE);
		bib.ajouterDocument("Ibn Kathir exegese", 2365, Type.LIVRE);
		bib.ajouterDocument("Islah", 2365, Type.REVUE);

		bib.getCompteur();
		System.out.println(bib.affiche());

	}

}
