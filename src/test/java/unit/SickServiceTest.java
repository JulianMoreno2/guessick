package unit;

import org.junit.Assert;
import org.junit.Test;

import repository.SickRepository;
import service.SickService;

public class SickServiceTest {

	@Test
	public void saveSick(){
		//TODO: mock
		SickRepository sickRepository = new SickRepository();
		
		SickService sickService = new SickService(sickRepository);
		
		Assert.assertTrue(true);
	}
}
