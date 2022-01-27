package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Bibliotheque {

	private String nom;

//	private Document[] lesDocs = new Document[5];
//	private int nbDoc = 0;

	List<Document> lesDocs = new ArrayList<Document>();
	Map<String, Set<Document>> map = new HashMap<String, Set<Document>>();

	public Bibliotheque(String nom) {
		this.nom = nom;
	}

	public int getCompteur() {
		return Document.getCompteur();
	}

	public void ajouterDocument(String cle, String titre, int nbPage, String auteur) {
		Livre l = new Livre(titre, nbPage, auteur);
		lesDocs.add(l);
		createSet(cle, l);

	}

	public void ajouterDocument(String cle, String titre, int nbPage, Frequence frequence) {
		Revue r = new Revue(titre, nbPage, frequence);
		lesDocs.add(r);
		createSet(cle, r);
	}

	private void createSet(String cle, Document l) {
		Set<Document> s = map.get(cle);
		if (s == null) {
			s = new HashSet<Document>();
			map.put(cle, s);
		}
		s.add(l);
	}

	public String affiche() {
		String ret = "";

		for (Object doc : lesDocs) {
			ret += doc.toString() + "\n";
		}
		return ret;

	}

	public String afficheLesCles() {
		String ret = "";
		for (String s : map.keySet()) {
			ret += s + "\n";
		}

		return ret;
	}

	public Set<Document> getDocument(String string) {

		return map.get(string);
	}

	public Iterable<Document> getDocuments() {

		return lesDocs;
	}

}
