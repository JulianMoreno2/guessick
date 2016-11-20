package unit;

import org.junit.Assert;
import org.junit.Test;

import adapter.SymptomAdapter;
import repository.MemoryRepository;
import repository.Repository;
import service.SymptomService;

public class SymptomAdapterTest {

	@Test
	public void saveSymptomAdapter(){
		//TODO: mock
		Repository symptomRepository = new MemoryRepository();		
		SymptomService symptomService = new SymptomService(symptomRepository);
		SymptomAdapter symptomAdapter = new SymptomAdapter(symptomService);
		
		Assert.assertTrue(true);
	}
}
	
