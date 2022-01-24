package metier;

class Document {

	private String titre;
	private int nbPage;
	private Type type;

	private static int compteur = 0;

	public Document(String titre, int nbPage, Type type) {

		this.titre = titre;
		this.nbPage = nbPage;
		this.type = type;
		compteur++;
	}

	public static int getCompteur() {
		return compteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbPage() {
		return nbPage;
	}

	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}

	public String affiche() {

		return "type: " + type + ", Nom: " + getTitre() + " " + "nbPage: " + getNbPage();
	}

}
