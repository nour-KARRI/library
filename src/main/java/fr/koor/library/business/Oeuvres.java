package fr.koor.library.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Oeuvres {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "idSavant", nullable = false)
	private Savants savants;
	private String livres;
	private String image;

	public Oeuvres() {
	}

	public Oeuvres(int id, Savants savants, String livres, String image) {
		super();
		this.id = id;
		this.savants = savants;
		this.livres = livres;
		this.image = image;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLivres() {
		return livres;
	}

	public void setLivres(String livres) {
		this.livres = livres;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Oeuvres [id=" + id + ", livres=" + livres + ", image=" + image + "]";
	}

}
