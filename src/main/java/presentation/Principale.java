package presentation;

import metier.Bibliotheque;
import metier.Frequence;

public class Principale {

	public static void main(String[] args) {

		Bibliotheque bib = new Bibliotheque("BibNour");

		bib.ajouterDocument("hadith", "Sahih mouslim", 44450, "Mouslim");
		bib.ajouterDocument("hadith", "Boulough Al Maram", 1235, "Ibn Hajar");
		bib.ajouterDocument("exegese", "Ibn Kathir exegese", 2365, "Ibn Kathir");
		bib.ajouterDocument("education", "Islah", 2365, Frequence.MENSEUL);

		bib.getCompteur();

//		Iterable lesDocs = bib.getDocuments();
//
//		Iterator it = lesDocs.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//
//		}

		for (Object o : bib.getDocuments()) {
			System.out.println(o);
		}

//		System.out.println(bib.affiche());
//		System.out.println("les cles: \n" + bib.afficheLesCles());
//		for (Object b : bib.getDocument("hadith")) {
//			System.out.println("pour Hadith: " + b);
//		}

	}

}
