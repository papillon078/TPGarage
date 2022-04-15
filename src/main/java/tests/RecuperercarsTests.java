package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import dbutils.Cars;




public class RecuperercarsTests {
	
	
	
	@Test
	public void shouldStart() {
		
		assertTrue(true);
	}

	@Test
	public void RecuperercarsRespond() {
		// verification que la fonction retourne le resultat de la requete
		assertNotNull(new Cars().recuperercars());
	}

}
