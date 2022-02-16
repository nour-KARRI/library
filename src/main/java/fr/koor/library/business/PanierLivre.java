package fr.koor.library.business;

public class PanierLivre {

	private Oeuvres oeuvres;
	private int quantity;
	
	public PanierLivre( Oeuvres oeuvres, int quantity) {
		setOeuvres(oeuvres);
		setQuantity(quantity);
	}
	
	
	public Oeuvres getOeuvres() {
		return oeuvres;
	}
	public void setOeuvres(Oeuvres oeuvres) {
		if (oeuvres ==null) throw new NullPointerException();
		this.oeuvres = oeuvres;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public void increaseQuantity() {
		this.quantity++;
	}
	
}
