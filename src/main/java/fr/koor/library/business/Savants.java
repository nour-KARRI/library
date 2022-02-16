package fr.koor.library.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "savants")
public class Savants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSavant")
	private int id;
	private String nom;
	private String pays;
	private String domaine;
	private String siecle;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Oeuvres.class, mappedBy = "savants")
	List<Oeuvres> oeuvres = new ArrayList<>();

	public Savants() {

	}

	public Savants(int id, String nom, String pays, String domaine, String siecle) {
		super();
		this.setId(id);
		this.nom = nom;
		this.pays = pays;
		this.domaine = domaine;
		this.siecle = siecle;
	}

	public List<Oeuvres> getOeuvres() {
		return oeuvres;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getSiecle() {
		return siecle;
	}

	public void setSiecle(String siecle) {
		this.siecle = siecle;
	}

	@Override
	public String toString() {
		return "Savants [nom=" + nom + ", pays=" + pays + ", domaine=" + domaine + ", siecle=" + siecle + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
