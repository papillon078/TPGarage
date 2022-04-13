package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import dbutils.Cars;

public class ReserverUneVoiture {
	@Test
	public void isCar16Available() {
		// test d'integration de tentative de reservation de la renault clio (libre dans la BDD)
		assertNotNull(new Cars().loadDatabase());
		assertNotNull(new Cars().recuperercars());
		assertEquals(false, new Cars().isReserved(16));
		assertEquals(false, new Cars().isBlocked(16));
	}
	
}
