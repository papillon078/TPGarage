package tests;

import static org.junit.Assert.assertEquals;
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
		// stade de dev : la fonction ne fait que retourner true
		assertNotNull(new Cars().recuperercars());
	}

}
