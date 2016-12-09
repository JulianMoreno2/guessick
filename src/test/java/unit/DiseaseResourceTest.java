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
		
		DiseaseDTO diseaseDTO = new DiseaseDTO("disease");
		Disease disease = diseaseResource.saveDisease(diseaseDTO);
		
		Assert.assertEquals("disease", disease.getName());
	}
	
	@Test
	public void diseaseResourceLoadSymptom(){
		
		Repository diseaseRepository = Given.giveMemoryRepository();
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		DiseaseAdapter diseaseAdapter = new DiseaseAdapter(diseaseService);
		SaveDiseaseResource saveDiseaseResource = new SaveDiseaseResource(diseaseAdapter);
		
		LoadDiseaseResource loadDiseaseResource = new LoadDiseaseResource(diseaseAdapter);
		
		DiseaseDTO diseaseDTO = new DiseaseDTO("disease");
		saveDiseaseResource.saveDisease(diseaseDTO);
				
		String diseaseName = "disease";
		Disease diseaseLoaded = loadDiseaseResource.loadDisease(diseaseName);
				
		Assert.assertEquals("disease", diseaseLoaded.getName());
	}
}
