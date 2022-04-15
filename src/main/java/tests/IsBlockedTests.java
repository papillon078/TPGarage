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
	public void isBlockedRespond() {
		// stade de dev : la fonction ne fait que retourner true
		assertEquals(true, new Cars().isBlocked(18));
	}
	
	@Test
	public void isBlocked15True() {
		// stade de dev : verification que l'argument est bien reçu et utilisé
		assertEquals(true, new Cars().isBlocked(18));
	}
	
	@Test
	public void isBlockedidNotExist() {
		// stade de dev : verification que la requete fonctionne avec l'id en dur
		assertEquals(false, new Cars().isBlocked(19));
	}
	@Test
	public void isBlockedHard18True() {
		// stade de dev : verification que la requete fonctionne avec l'id en dur
		assertEquals(true, new Cars().isBlocked(18));
	}
	@Test
	public void isBlockedHard16false() {
		// stade de dev :verification que la requete fonctionne avec l'id en dur
		assertEquals(false, new Cars().isBlocked(16));
	}
	
	@Test
	public void isBlockedTrue() {
		// TEST FINAL : la voiture d'id 18 est bloquée pour achat dans la BDD
		assertEquals(true, new Cars().isBlocked(18));
	}
	
	@Test
	public void isBlockedFalse() {
		// TEST FINAL : la voiture d'id 16 n'est pas bloquée pour achat dans la BDD
		assertEquals(false, new Cars().isBlocked(16));
	}
}
