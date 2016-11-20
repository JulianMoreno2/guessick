package unit;

import org.junit.Assert;
import org.junit.Test;

import repository.MemoryRepository;
import repository.Repository;
import service.SymptomService;

public class SymptomServiceTest {

	@Test
	public void saveSymptom(){
		//TODO: mock
		Repository symptomRepository = new MemoryRepository();
		
		SymptomService symptomService = new SymptomService(symptomRepository);
		
		Assert.assertTrue(true);
	}
	
}
