package metier;

import interfaces.Affichable;

public class Revue extends Document implements Affichable {

	private Frequence frequence;

	public Revue(String titre, int nbPage, Frequence frequence) {
		super(titre, nbPage);
		this.setFrequence(frequence);
	}

//	@Override
//	public String affiche() {
//
//		return super.affiche() + ", Frequence: " + getFrequence();
//	}

	public Frequence getFrequence() {
		return frequence;
	}

	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}

	@Override
	public String affiche() {
		return super.toString() + ", Frequence: " + getFrequence();
	}

}
