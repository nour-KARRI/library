package fr.koor.library.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletOutputStream;

import fr.koor.library.business.Oeuvres;
import fr.koor.library.business.Savants;

public class SavantsDAO extends DAOContext {

	EntityManagerFactory emf = null;
	EntityManager em = null;

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

	/*
	 * public List<Savants> getListSavantsAAA() {
	 * 
	 * try { emf = Persistence.createEntityManagerFactory("Library"); em =
	 * emf.createEntityManager();
	 * 
	 * Savants savants = em.find(Savants.class, 1);
	 * 
	 * System.out.println(
	 * "**************************************************************");
	 * System.out.println("************ savants: " + savants);
	 * 
	 * List<Oeuvres> oeuvres = savants.getOeuvres(); System.out.println(
	 * "*****************oeuvres*****************oeuvres****************************"
	 * );
	 * 
	 * for (Oeuvres o : oeuvres) { System.out.println(o.getLivres()); }
	 * 
	 * List<Savants> listSavants = new ArrayList<>(); listSavants =
	 * em.createQuery("from Savants", Savants.class).getResultList();
	 * 
	 * return listSavants; } finally { if (em != null) em.close(); if (emf != null)
	 * emf.close(); } }
	 */
	public List<Oeuvres> getListLivres(int savantId) {
		List<Oeuvres> listOeuvres = new ArrayList<>();
		// List<String> livres = new ArrayList<>();

		try {
			emf = Persistence.createEntityManagerFactory("Library");
			em = emf.createEntityManager();

			Savants savants = em.find(Savants.class, savantId);
			System.out.println("**************************************************************");
			System.out.println("************ savants: " + savants);

			listOeuvres = savants.getOeuvres();

		} finally {
			if (em != null)
				em.close();
			if (emf != null)
				emf.close();
		}
//		try (Connection con = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
//
//			String str = "SELECT * FROM oeuvres WHERE idSavant=?";
//			byte[] img;
//			try (PreparedStatement statement = con.prepareStatement(str)) {
//				statement.setInt(1, savantId);
//
//				try (ResultSet resultSet = statement.executeQuery()) {
//					while (resultSet.next()) {
//						id = resultSet.getInt("Id");
//						idSavant =
//
//								resultSet.getInt("idSavant");
//						livre = resultSet.getString("livres");
//
//						img = resultSet.getBytes("image");
//						String imgString = Base64.getEncoder().encodeToString(img);
//						livres = new Oeuvres(id, idSavant, livre, imgString);
//						listLivres.add(livres);
//					}
//				}
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return listOeuvres;
	}

	public String getNomSavant(int savantId) {

		String nom = null;
		try (Connection con = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {

			String str = "SELECT nom FROM savants WHERE idSavant=?";

			try (PreparedStatement statement = con.prepareStatement(str)) {
				statement.setInt(1, savantId);

				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						nom = resultSet.getString("nom");
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nom;
	}

	public static int getCountLivre() {
		int countLivre = 0;
		try (Connection con = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {
			ResultSet result;
			String str = "SELECT count(livres) as countLivre FROM oeuvres";
			PreparedStatement statment = con.prepareStatement(str);

			result = statment.executeQuery();
			while (result.next()) {
				countLivre = result.getInt("countLivre");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countLivre;
	}

	public static Oeuvres getElementbyId(int currentPosition) {
		Oeuvres livres = null;
		byte[] img = null;
		ServletOutputStream sos = null;

		int id, idSavant = 0;
		String livre = null;
		try (Connection con = DriverManager.getConnection(dbURL, dbLogin, dbPassword)) {

			String str = "SELECT * FROM oeuvres WHERE Id=?";

			try (PreparedStatement statement = con.prepareStatement(str)) {
				statement.setInt(1, currentPosition);

				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						id = resultSet.getInt("Id");
						idSavant = resultSet.getInt("idSavant");
						livre = resultSet.getString("livres");
						img = resultSet.getBytes("image");
						String imgString = Base64.getEncoder().encodeToString(img);
						// livres = new Oeuvres(id, idSavant, livre, imgString);

					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livres;
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