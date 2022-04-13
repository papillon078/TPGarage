package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import dbutils.Cars;



public class IsBlockedTests {

	@Test
	public void shouldStart() {
		
		assertTrue(true);
	}

	@Test
	public void isReservedRespond() {
		// stade de dev : la fonction ne fait que retourner true
		assertEquals(true, new Cars().isBlocked(18));
	}
	
	@Test
	public void isReserved15True() {
		// verification que l'argument est bien reçu et utilisé
		assertEquals(true, new Cars().isBlocked(18));
	}
	
	@Test
	public void isReservedidNotExist() {
		// verification que la requete fonctionne avec l'id en dur
		assertEquals(false, new Cars().isBlocked(19));
	}
	@Test
	public void isReservedHard15True() {
		// verification que la requete fonctionne avec l'id en dur
		assertEquals(false, new Cars().isBlocked(18));
	}
	@Test
	public void isReservedHard16false() {
		// verification que la requete fonctionne avec l'id en dur
		assertEquals(false, new Cars().isBlocked(16));
	}
	
	@Test
	public void isReservedTrue() {
		// la voiture d'id 18 est reservée dans la BDD
		assertEquals(true, new Cars().isBlocked(18));
	}
	
	@Test
	public void isReservedFalse() {
		// la voiture d'id 16 n'est pas reservée dans la BDD
		assertEquals(false, new Cars().isBlocked(16));
	}
}
