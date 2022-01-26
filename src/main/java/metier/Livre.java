package metier;

import interfaces.Affichable;

public final class Livre extends Document implements Affichable {

	private String auteur;

	public Livre(String titre, int nbPage, String auteur) {
		super(titre, nbPage);

		this.setAuteur(auteur);

	}

//	@Override
//	public String affiche() {
//
//		return super.affiche() + ", Auteur: " + getAuteur();
//	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String affiche() {
		return super.toString() + ", Auteur: " + getAuteur();

	}

}
