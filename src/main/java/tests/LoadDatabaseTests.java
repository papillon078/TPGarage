package tests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import dbutils.Cars;

public class LoadDatabaseTests {

	@Test
	public void loadDatabaseRespond() {
		// stade de dev : la fonction ne fait que retourner true
		assertNotNull(new Cars().loadDatabase());
	}
}
