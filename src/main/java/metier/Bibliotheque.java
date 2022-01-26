package metier;

import interfaces.Affichable;

public final class Bibliotheque {

	private String nom;

	private Document[] lesDocs = new Document[5];
	private int nbDoc = 0;

	public Bibliotheque(String nom) {
		this.nom = nom;
	}

	public int getCompteur() {
		return Document.getCompteur();
	}

	public void ajouterDocument(String titre, int nbPage, String auteur) {
		lesDocs[nbDoc++] = new Livre(titre, nbPage, auteur);
	}

	public void ajouterDocument(String titre, int nbPage, Frequence frequence) {
		lesDocs[nbDoc++] = new Revue(titre, nbPage, frequence);
	}

	public String affiche() {
		String ret = "";
		for (int i = 0; i < nbDoc; i++) {
			ret += lesDocs[i].affiche() + "\n";
		}
		return ret;

	}

	public Affichable getAt(int j) {
		Affichable ret = null;
		if (lesDocs[j] instanceof Affichable) {
			ret = (Affichable) lesDocs[j];
		}
		return ret;
	}

}
