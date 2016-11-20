package unit;

import org.junit.Assert;
import org.junit.Test;

import repository.MemoryRepository;
import repository.Repository;
import service.SickService;

public class SickServiceTest {

	@Test
	public void saveSick(){
		//TODO: mock
		Repository sickRepository = new MemoryRepository();
		
		SickService sickService = new SickService(sickRepository);
		
		Assert.assertTrue(true);
	}
}
