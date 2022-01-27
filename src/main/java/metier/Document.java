package metier;

abstract class Document {

	private String titre;
	private int nbPage;

	private static int compteur = 0;

	public Document(String titre, int nbPage) {

		this.titre = titre;
		this.nbPage = nbPage;
		compteur++;
	}

	public static int getCompteur() {
		return compteur;
	}

	public final String getTitre() {
		return titre;
	}

	public final void setTitre(String titre) {
		this.titre = titre;
	}

	public final int getNbPage() {
		return nbPage;
	}

	public final void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}

	@Override
	public String toString() {
		return "titre: " + getTitre() + " " + ", nbPage: " + getNbPage();
	}

}
