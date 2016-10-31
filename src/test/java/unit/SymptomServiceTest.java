package unit;

import org.junit.Assert;
import org.junit.Test;

import repository.SymptomRepository;
import service.SymptomService;

public class SymptomServiceTest {

	@Test
	public void saveSymptom(){
		//TODO: mock
		SymptomRepository symptomRepository = new SymptomRepository();
		
		SymptomService symptomService = new SymptomService(symptomRepository);
		
		Assert.assertTrue(true);
	}
	
}
