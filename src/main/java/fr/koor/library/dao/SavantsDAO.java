package fr.koor.library.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.koor.library.business.Oeuvres;
import fr.koor.library.business.Savants;

public class SavantsDAO extends DAOContext {

	static EntityManagerFactory emf = null;
	static EntityManager em = null;

	public List<Savants> getListSavants() {

		try {
			emf = Persistence.createEntityManagerFactory("Library");
			em = emf.createEntityManager();

			List<Savants> listSavants = new ArrayList<>();
			listSavants = em.createQuery("from Savants", Savants.class).getResultList();

			return listSavants;
		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}
	}

	public List<Oeuvres> getListLivres(int savantId) {
		List<Oeuvres> listOeuvres = new ArrayList<>();

		try {
			emf = Persistence.createEntityManagerFactory("Library");
			em = emf.createEntityManager();

			Savants savants = em.find(Savants.class, savantId);
			listOeuvres = savants.getOeuvres();

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}
		return listOeuvres;
	}

	public static Oeuvres getElementbyId(int currentPosition) {
		Oeuvres livres = null;

		try {
			emf = Persistence.createEntityManagerFactory("Library");
			em = emf.createEntityManager();
			livres = em.find(Oeuvres.class, currentPosition);

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}
		return livres;
	}

	public String getPrenomSavant(int savantId) {

		try {
			emf = Persistence.createEntityManagerFactory("Library");
			em = emf.createEntityManager();
			return em.find(Savants.class, savantId).getNom();
		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}
	}

	public static int getCountLivre() {
		int count;
		try {
			emf = Persistence.createEntityManagerFactory("Library");
			em = emf.createEntityManager();
			Query query = em.createQuery("SELECT count(*) FROM Oeuvres");
			count = ((Long) query.getSingleResult()).intValue();

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}

		return count;
	}

	public void InertImage() {
		try (Connection con = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {

			String str = "UPDATE oeuvres SET image =? WHERE Id = ?";
			PreparedStatement statement = con.prepareStatement(str);

			InputStream in;

			in = new FileInputStream("C:\\images\\la-voie-de-la-patience.jpg");

			statement.setBlob(1, in);
			statement.setInt(2, 12);
			statement.executeUpdate();

		} catch (SQLException | FileNotFoundException e) { // TODO Auto-generated
			e.printStackTrace();
		}

	}

}