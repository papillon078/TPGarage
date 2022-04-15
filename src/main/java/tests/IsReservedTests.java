package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import dbutils.Cars;



public class IsReservedTests {

	@Test
	public void shouldStart() {
		
		assertTrue(true);
	}

	@Test
	public void isReservedRespond() {
		// stade de dev : la fonction ne fait que retourner true
		assertEquals(true, new Cars().isReserved(15));
	}
	
	@Test
	public void isReserved15True() {
		// stade de dev : verification que l'argument est bien reçu et utilisé
		assertEquals(true, new Cars().isReserved(15));
	}
	
	@Test
	public void isReservedidNotExist() {
		// stade de dev : verification que la requete fonctionne avec l'id en dur
		assertEquals(false, new Cars().isReserved(19));
	}
	@Test
	public void isReservedHard15True() {
		// stade de dev : verification que la requete fonctionne avec l'id en dur
		assertEquals(true, new Cars().isReserved(15));
	}
	@Test
	public void isReservedHard16false() {
		// stade de dev : verification que la requete fonctionne avec l'id en dur
		assertEquals(false, new Cars().isReserved(16));
	}
	
	@Test
	public void isReservedTrue() {
		// TEST FINAL : la voiture d'id 15 est reservée dans la BDD
		assertEquals(true, new Cars().isReserved(15));
	}
	
	@Test
	public void isReservedFalse() {
		// TEST FINAL : la voiture d'id 16 n'est pas reservée dans la BDD
		assertEquals(false, new Cars().isReserved(16));
	}
}
