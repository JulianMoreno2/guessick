package unit;

import org.junit.Assert;
import org.junit.Test;

import adapter.SymptomAdapter;
import repository.Repository;
import service.SymptomService;

public class SymptomAdapterTest {

	@Test
	public void saveSymptomAdapter(){
		//TODO: mock
		Repository symptomRepository = new Repository();		
		SymptomService symptomService = new SymptomService(symptomRepository);
		SymptomAdapter symptomAdapter = new SymptomAdapter(symptomService);
		
		Assert.assertTrue(true);
	}
}
	
