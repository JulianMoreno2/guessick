package unit;

import org.junit.Assert;
import org.junit.Test;

import adapter.DiseaseAdapter;
import domain.Disease;
import dto.DiseaseDTO;
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
		
		DiseaseDTO diseaseDTO = Given.giveDiseaseDTO();
		Disease disease = diseaseAdapter.saveDisease(diseaseDTO);
		
		Assert.assertEquals("1", disease.getId());
	}
}
