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
		Repository diseaseRepository = new MemoryRepository();		
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		DiseaseAdapter diseaseAdapter = new DiseaseAdapter(diseaseService);
		
		DiseaseDTO diseaseDTO = Given.giveDiseaseDTO();
		Disease disease = diseaseAdapter.saveDisease(diseaseDTO);
		
		Assert.assertEquals("0", disease.getId());
	}
	
	@Test
	public void loadSymptomAdapter(){
		Repository diseaseRepository = new MemoryRepository();		
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		DiseaseAdapter diseaseAdapter = new DiseaseAdapter(diseaseService);
		
		DiseaseDTO diseaseDTO = Given.giveDiseaseDTO();
		diseaseAdapter.saveDisease(diseaseDTO);
		
		String diseaseId = "0";
		Assert.assertEquals(diseaseId, diseaseAdapter.loadDisease(diseaseId).getId());
	}
	
	
}
