package unit;

import org.junit.Assert;
import org.junit.Test;

import adapter.DiseaseAdapter;
import repository.MemoryRepository;
import repository.Repository;
import service.DiseaseService;

public class DiseaseAdapterTest {
	
	@Test
	public void saveSickAdapter(){
		//TODO: mock
		Repository sickRepository = new MemoryRepository();		
		DiseaseService diseaseService = new DiseaseService(sickRepository);
		DiseaseAdapter diseaseAdapter = new DiseaseAdapter(diseaseService);
		
		Assert.assertTrue(true);
	}
}
