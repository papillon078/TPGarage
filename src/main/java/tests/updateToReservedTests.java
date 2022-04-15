package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import dbutils.Cars;



public class updateToReservedTests {

	@Test
	public void shouldStart() {
		
		assertTrue(true);
	}

	@Test
	public void updateToReservedRespond() {
		// stade de dev : la fonction ne fait que retourner true
		assertEquals(true, new Cars().updateToReserved(16));
	}
	
	@Test
	public void updateToReserved16ParameterTrue() {
		// stade de dev : verification que l'argument est bien reçu et utilisé
		assertEquals(true, new Cars().updateToReserved(16));
	}
	
	@Test
	public void updateToReservedIdNotExist() {
		// stade de dev : verification que la requete fonctionne avec l'id en dur
		assertEquals(false, new Cars().updateToReserved(19));
	}
	
	@Test
	public void updateToReservedHard16True() {
		// stade de dev : verification que la requete fonctionne avec l'id en dur
		assertEquals(true, new Cars().updateToReserved(16));
	}
	
		
	@Test
	public void updateToReserved17True() {
		// TEST FINAL : la voiture d'id 17 n'est pas reservée dans la BDD
		assertEquals(true, new Cars().updateToReserved(17));
	}
}
