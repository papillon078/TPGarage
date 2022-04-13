package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Car;

public class Cars {

private Connection connexion;
	
	//insere un car dans la table car
	public Boolean ajouteCar(Car car) {
		boolean statut = false;
		//1. etablissement de la connexion
		loadDatabase();
		
		//2. preparation et execution de la requete
		try {
			// Preparation
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO car(brand, model, year, parkingNumber, reservation_status, block_status, owner) VALUES(?,?,?,?,?,?,?);");
			preparedStatement.setString(1, car.getBrand());
			preparedStatement.setString(2, car.getModel());
			preparedStatement.setString(3, car.getYear());
			preparedStatement.setString(4, car.getParkingNumber());
			preparedStatement.setBoolean(5, car.getReservation_status());
			preparedStatement.setBoolean(6, car.getBlock_status());
			preparedStatement.setInt(7, car.getOwner());
			
			
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
	
	//recupere toutes les informations de la table "car"
	public List<Car> recuperercars(){
		// 1. initialisation des variables
		List<Car> cars = new ArrayList<Car>();
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
			resultat = statement.executeQuery("Select id, brand, model, year, parkingNumber, reservation_status, block_status, owner FROM cars;");
			
			//recuperation des données
			while(resultat.next()){
				Integer id = resultat.getInt("id");
				String brand = resultat.getString("brand");
				String model = resultat.getString("model");
				String year = resultat.getString("year");
				String parkingNumber = resultat.getString("parkingNumber");
				Boolean reservation_status = resultat.getBoolean("reservation_status");
				Boolean block_status = resultat.getBoolean("block_status");
				Integer owner = resultat.getInt("owner");
				
				//on met les info de base de donnée dans un objet car que l'on ajoute a une liste "cars"
				Car car = new Car(id, brand, model, year, parkingNumber, reservation_status, block_status, owner);
				cars.add(car);
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
		
		return cars;
	}
	
	public Boolean isReserved(int id) {
		
		
		// 1. initialisation des variables
		Boolean reservationStatus = false;
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
					resultat = statement.executeQuery("Select reservation_status FROM cars WHERE id = "+id+";");
					
					//recuperation des données
			while(resultat.next()){
					reservationStatus = resultat.getBoolean("reservation_status");
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
				
		return reservationStatus;
	}
	
public Boolean isBlocked(int id) {
		
		
		// 1. initialisation des variables
		Boolean blockStatus = false;
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
					resultat = statement.executeQuery("Select block_status FROM cars WHERE id = "+id+";");
					
					//recuperation des données
			while(resultat.next()){
				blockStatus = resultat.getBoolean("block_status");
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
				
		return blockStatus;
	}
	
	// Permet d'etablir la connexion entre la base de donnée et le serveur
	public Connection loadDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			
		}
		try {
		connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpgaragiste?characterEncoding=utf8","root","");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connexion;
}
}
