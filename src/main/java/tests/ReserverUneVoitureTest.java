package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import dbutils.Cars;

public class ReserverUneVoitureTest {

	//TEST d'INTEGRATION
	
	@Test
	public void car15alreadyReserved() {
		// test d'integration de tentative de reservation de la renault MeganeRS 
		//(deja réservée dans la BDD)
		assertEquals("La voiture est deja reservée, veuillez choisir une autre voiture", new Cars().carReserving(15));
	}
	
	@Test
	public void car18alreadyBlocked() {
		// test d'integration de tentative de reservation de la ford Focus 
		//(deja bloquée pour achat dans la BDD)
		assertEquals("La voiture est bloquée pour achat, veuillez choisir une autre voiture", new Cars().carReserving(18));
	}
	
	@Test
	public void car17AvailableForReserving() {
		// test d'integration de tentative de reservation de l'audi TT 
		//(disponible a la reservation dans la BDD)
		assertEquals("La voiture est libre pour un essai, vous recevrez un mail de confirmation de reservation", new Cars().carReserving(17));
	}
	
}
