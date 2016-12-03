package unit;

import org.junit.Assert;
import org.junit.Test;

import repository.MemoryRepository;
import repository.Repository;
import service.DiseaseService;

public class DiseaseServiceTest {

	@Test
	public void saveSick(){
		//TODO: mock
		Repository sickRepository = new MemoryRepository();
		
		DiseaseService diseaseService = new DiseaseService(sickRepository);
		
		Assert.assertTrue(true);
	}
}
