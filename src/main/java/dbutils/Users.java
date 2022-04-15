package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.User;

public class Users {

	/********************************************
	 * Cette page regroupe toutes les fonctions et requetes en rapport avec la table users
	 *******************************************/
	
	private Connection connexion;
	
	//insere un user dans la table user
	public Boolean ajouteUser(User user) {
		boolean statut = false;
		//1. etablissement de la connexion
		loadDatabase();
		
		//2. preparation et execution de la requete
		try {
			// Preparation
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO user(nom, age, sexe, adresse, ville) VALUES(?,?,?,?,?);");
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getRole());
			preparedStatement.setString(4, user.getMail());
			preparedStatement.setString(5, user.getPassword());
			
			// Execution
			preparedStatement.executeUpdate();
			
			// renvoie de l'ID géneré pour verifier le succes de l'insertion
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			//renvoie ce qu'il y a dans la 1ere colonne
			int value = rs.getInt(1);
			
			if(value>0) {
				statut = true;
			}
			
		}catch(SQLException e) {
			System.out.println("erreur insertion SQL : "+e.getMessage());
			
		}finally {
			   //4. fermeture de la connexion
			   try {
				    if( connexion != null )connexion.close();
			   }catch(SQLException e) {
				   System.out.println("Erreur fermeture connexion SQL : "+e.getMessage());
				   
			   } 
				
		   }
		return statut;
	}
	
	//recupere toutes les informations de la table "user"
	public List<User> recupererusers(){
		// 1. initialisation des variables
		List<User> users = new ArrayList<User>();
		// Permet de rediger la requete
		Statement statement = null;
		//Permet de recuperer le resultat de la requete
		ResultSet resultat = null;
		
		//2. Etablir la connexion a la BDD
		loadDatabase();
		
		//3. Redaction et lancement de la requete
		try {
			statement = connexion.createStatement();
			//execution de la requete
			resultat = statement.executeQuery("Select firstname, lastname, role, mail, password FROM users;");
			
			//recuperation des données
			while(resultat.next()){
				String firstname = resultat.getString("firstname");
				String lastname = resultat.getString("lastname");
				String role = resultat.getString("role");
				String mail = resultat.getString("mail");
				String password = resultat.getString("password");
				
				//on met les info de base de donnée dans un objet user que l'on ajoute a une liste "users"
				User user = new User(firstname, lastname, role, mail, password);
				users.add(user);
			}
		}catch(SQLException e) {
			System.out.println("erreur traiement SQL : "+e.getMessage());
		}finally {
			try {
				if (resultat != null) resultat.close();
				if (statement != null) statement.close();
				if (connexion != null) connexion.close();
			}catch(SQLException e) {
				System.out.println("erreur fermeture connexion SQL : "+e.getMessage());
			}
		}
		
		return users;
	}
	
	// Permet d'etablir la connexion entre la base de donnée et le serveur
	public void loadDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			
		}
		try {
		connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpgaragiste?characterEncoding=utf8","root","");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
