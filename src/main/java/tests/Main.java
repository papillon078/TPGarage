package tests;


import java.util.List;

import dbutils.Cars;
import dbutils.Users;
import entities.Car;
import entities.User;

public class Main {

	public static void main(String[] args) {
		// comment afficher toute la table users
		Users user = new Users();
		System.out.println(user.recupererusers());
		List<User> usersList = user.recupererusers(); 
		for( User a : usersList) {
			System.out.println(a.getFirstname()+", "+a.getLastname()+", "+a.getRole()+", "+a.getMail()+", "+a.getPassword()+"\t");
		}
		
		// comment afficher toute la table cars
				Cars car = new Cars();
				System.out.println(car.recuperercars());
				List<Car> carsList = car.recuperercars(); 
				for( Car a : carsList) {
					System.out.println(a.getBrand()+", "+a.getModel()+", "+a.getYear()+", "+a.getParkingNumber()+", "+a.getReservation_status()+", "+a.getBlock_status()+", "+a.getOwner()+"\t");
				}
		
				Cars car2 = new Cars();
				Boolean result = car2.isReserved(15);
				System.out.println("est elle reservée : "+result);
		
	}

}
