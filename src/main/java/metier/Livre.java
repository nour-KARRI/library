package metier;

public final class Livre extends Document {

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
	public String toString() {
		return super.toString() + ", Auteur: " + getAuteur();

	}

}
