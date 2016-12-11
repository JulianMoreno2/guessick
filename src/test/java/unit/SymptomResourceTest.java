package unit;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import domain.Symptom;
import repository.MemoryRepository;
import repository.Repository;
import resources.LoadSymptomResource;
import resources.SaveSymptomResource;
import service.SymptomService;

public class SymptomResourceTest {
	
	Repository repository;
	SymptomService symptomService;
	SaveSymptomResource saveSymptomResource;
	
	@Before
	public void doBefore(){
		repository = new MemoryRepository();
		symptomService = new SymptomService(repository);
		saveSymptomResource = new SaveSymptomResource(symptomService);
	}

	@Test
	public void symptomResourceSaveSymptom(){
		
		Symptom symptom = new Symptom("symptom");
		Symptom symptomReturned = saveSymptomResource.saveSyptom(symptom);
		
		Assert.assertEquals("symptom", symptomReturned.getName());
	}
	
	@Test
	public void symptomResourceLoadSymptom(){
		
		LoadSymptomResource loadSymptomResource = new LoadSymptomResource(symptomService);
		
		Symptom symptom = new Symptom("symptom");
		saveSymptomResource.saveSyptom(symptom);
				
		String symptomName = "symptom";
		Symptom symptomLoaded = loadSymptomResource.loadSymptom(symptomName);
				
		Assert.assertEquals("symptom", symptomLoaded.getName());
	}
	
}
