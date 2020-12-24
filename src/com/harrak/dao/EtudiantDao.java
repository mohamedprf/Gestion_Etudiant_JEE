package com.harrak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.harrak.model.Etudiant;
import com.harrak.util.DbUtil;



public class EtudiantDao {

	private Connection connection;

	public EtudiantDao() {
		connection = DbUtil.getConnection();
	}
	
	public void AjouterEtudiant(Etudiant etudiant) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into etudiant(nom, prenom, sexe, email, filiere) values (?,?, ?, ?, ? )");
			preparedStatement.setString(1, etudiant.getNom());
			preparedStatement.setString(2, etudiant.getPrenom());
			preparedStatement.setString(3, etudiant.getSexe());
			preparedStatement.setString(4, etudiant.getEmail());
			preparedStatement.setString(5, etudiant.getFiliere());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEtudiant(Etudiant etudiant) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update etudiant set nom=?, prenom=?, sexe=?, email=?, filiere=?" +
							"where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, etudiant.getNom());
			preparedStatement.setString(2, etudiant.getPrenom());
			preparedStatement.setString(3, etudiant.getSexe());
			preparedStatement.setString(4, etudiant.getEmail());
			preparedStatement.setString(5, etudiant.getFiliere());
			preparedStatement.setInt(6, etudiant.getId());


			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEtudiant(int id) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from etudiant where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Etudiant> getAllEtudiants() {
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from etudiant");
			while (rs.next()) {
				Etudiant etudiant = new Etudiant();
				etudiant.setId(rs.getInt("id"));
				etudiant.setNom(rs.getString("nom"));
				etudiant.setPrenom(rs.getString("prenom"));
				etudiant.setSexe(rs.getString("sexe"));
				etudiant.setEmail(rs.getString("email"));
				etudiant.setFiliere(rs.getString("filiere"));
				etudiants.add(etudiant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return etudiants;
	}
	
	public Etudiant getEtudiantById(int id) {
		Etudiant etudiant = new Etudiant();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from etudiant where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				etudiant.setId(rs.getInt("id"));
				etudiant.setNom(rs.getString("nom"));
				etudiant.setPrenom(rs.getString("prenom"));
				etudiant.setSexe(rs.getString("sexe"));
				etudiant.setEmail(rs.getString("email"));
				etudiant.setFiliere(rs.getString("filiere"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return etudiant;
		
		}
	
	
	
}

