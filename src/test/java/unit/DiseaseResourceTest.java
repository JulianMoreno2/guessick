package unit;

import adapter.DiseaseAdapter;
import domain.Disease;
import dto.DiseaseDTO;
import org.junit.Assert;
import org.junit.Test;
import repository.Repository;
import resources.LoadDiseaseResource;
import resources.SaveDiseaseResource;
import service.DiseaseService;

public class DiseaseResourceTest {
	
	@Test
	public void sickResourceSaveSymptom(){
		//TODO: mock
		Repository diseaseRepository = Given.giveMemoryRepository();
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		DiseaseAdapter diseaseAdapter = new DiseaseAdapter(diseaseService);
		SaveDiseaseResource diseaseResource = new SaveDiseaseResource(diseaseAdapter);
		
		DiseaseDTO diseaseDTO = new DiseaseDTO("1","disease");
		Disease disease = diseaseResource.saveDisease(diseaseDTO);
		
		Assert.assertEquals("1", disease.getId());
	}
	
	@Test
	public void diseaseResourceLoadSymptom(){
		
		Repository diseaseRepository = Given.giveMemoryRepository();
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		DiseaseAdapter diseaseAdapter = new DiseaseAdapter(diseaseService);
		SaveDiseaseResource saveDiseaseResource = new SaveDiseaseResource(diseaseAdapter);
		
		LoadDiseaseResource loadDiseaseResource = new LoadDiseaseResource(diseaseAdapter);
		
		DiseaseDTO diseaseDTO = new DiseaseDTO("1", "disease");
		saveDiseaseResource.saveDisease(diseaseDTO);
				
		String diseaseId = "1";
		Disease diseaseLoaded = loadDiseaseResource.loadDisease(diseaseId);
				
		Assert.assertEquals("disease", diseaseLoaded.getName());
	}
}
