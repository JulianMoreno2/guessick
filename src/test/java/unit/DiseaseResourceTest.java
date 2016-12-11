package unit;

import domain.Disease;
import org.junit.Assert;
import org.junit.Test;
import repository.Repository;
import resources.LoadDiseaseResource;
import resources.LoadPossibleDiseasesResource;
import resources.SaveDiseaseResource;
import service.DiseaseService;

public class DiseaseResourceTest {
	
	@Test
	public void diseaseResourceSaveSymptom(){
		//TODO: mock
		Repository diseaseRepository = Given.giveMemoryRepository();
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		SaveDiseaseResource diseaseResource = new SaveDiseaseResource(diseaseService);
		
		Disease disease = new Disease("disease");
		Disease diseaseReturned = diseaseResource.saveDisease(disease);
		
		Assert.assertEquals("disease", diseaseReturned.getName());
	}
	
	@Test
	public void diseaseResourceLoadSymptom(){
		
		Repository diseaseRepository = Given.giveMemoryRepository();
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		SaveDiseaseResource saveDiseaseResource = new SaveDiseaseResource(diseaseService);
		
		LoadDiseaseResource loadDiseaseResource = new LoadDiseaseResource(diseaseService);
		
		Disease disease = new Disease("disease");
		saveDiseaseResource.saveDisease(disease);
				
		String diseaseName = "disease";
		Disease diseaseLoaded = loadDiseaseResource.loadDisease(diseaseName);
				
		Assert.assertEquals("disease", diseaseLoaded.getName());
	}
	
	@Test
	public void loadPossibleDiseasesResourceTest(){
		
		Repository diseaseRepository = Given.giveMemoryRepository();
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		SaveDiseaseResource saveDiseaseResource = new SaveDiseaseResource(diseaseService);
		
		LoadPossibleDiseasesResource loadPossibleDiseasesResource = new LoadPossibleDiseasesResource(diseaseService);
		
		Disease disease = new Disease("disease");
		saveDiseaseResource.saveDisease(disease);
				
		//Assert.assertEquals("disease", diseaseLoaded.getName());
	}
}
