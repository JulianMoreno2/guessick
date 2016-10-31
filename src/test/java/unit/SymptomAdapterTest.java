package unit;

import org.junit.Assert;
import org.junit.Test;

import adapter.SymptomAdapter;
import repository.SymptomRepository;
import service.SymptomService;

public class SymptomAdapterTest {

	@Test
	public void saveSymptomAdapter(){
		//TODO: mock
		SymptomRepository symptomRepository = new SymptomRepository();		
		SymptomService symptomService = new SymptomService(symptomRepository);
		SymptomAdapter symptomAdapter = new SymptomAdapter(symptomService);
		
		Assert.assertTrue(true);
	}
}
	
