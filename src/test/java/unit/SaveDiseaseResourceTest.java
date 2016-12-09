package unit;

import adapter.DiseaseAdapter;
import domain.Disease;
import dto.DiseaseDTO;

import org.junit.Assert;
import org.junit.Test;
import repository.Repository;
import resources.SaveDiseaseResource;
import service.DiseaseService;

public class SaveDiseaseResourceTest {
	
	@Test
	public void sickResourceSaveSymptom(){
		//TODO: mock
		Repository diseaseRepository = Given.giveMemoryRepository();
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		DiseaseAdapter diseaseAdapter = new DiseaseAdapter(diseaseService);
		SaveDiseaseResource diseaseResource = new SaveDiseaseResource(diseaseAdapter);
		
		DiseaseDTO diseaseDTO = new DiseaseDTO("1","symptom");
		Disease disease = diseaseResource.saveDisease(diseaseDTO);
		
		Assert.assertEquals("1", disease.getId());
	}
}
