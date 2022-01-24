package metier;

public class Bibliotheque {

	private String nom;

	private Document[] lesDocs = new Document[5];
	private int nbDoc = 0;

	public Bibliotheque(String nom) {
		this.nom = nom;
	}

	public int getCompteur() {
		return Document.getCompteur();
	}

	public void ajouterDocument(String titre, int nbPage, Type type) {
		lesDocs[nbDoc++] = new Document(titre, nbPage, type);
	}

	public String affiche() {
		String ret = "";
		for (int i = 0; i < nbDoc; i++) {
			ret += lesDocs[i].affiche() + "\n";
		}
		return ret;

	}

}
