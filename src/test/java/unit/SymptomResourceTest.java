package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Symptom;
import repository.MemoryRepository;
import repository.Repository;
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

}
