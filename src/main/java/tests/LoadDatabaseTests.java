package tests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import dbutils.Cars;

public class LoadDatabaseTests {

	@Test
	public void loadDatabaseRespond() {
		// verification que la fonction ouvre biien une connexion
		assertNotNull(new Cars().loadDatabase());
	}
}
