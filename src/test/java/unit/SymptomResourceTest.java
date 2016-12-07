package unit;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import adapter.SymptomAdapter;
import domain.Symptom;
import dto.SymptomDTO;
import repository.MemoryRepository;
import repository.Repository;
import resources.LoadSymptomResource;
import resources.SaveSymptomResource;
import service.SymptomService;

public class SymptomResourceTest {
	
	Repository repository;
	SymptomService symptomService;
	SymptomAdapter symptomAdapter;
	SaveSymptomResource saveSymptomResource;
	
	@Before
	public void doBefore(){
		repository = new MemoryRepository();
		symptomService = new SymptomService(repository);
		symptomAdapter = new SymptomAdapter(symptomService);
		saveSymptomResource = new SaveSymptomResource(symptomAdapter);
	}

	@Test
	public void symptomResourceSaveSymptom(){
		
		SymptomDTO symptomDTO = new SymptomDTO("0","symptom");
		Symptom symptom = saveSymptomResource.saveSyptom(symptomDTO);
		
		Assert.assertEquals("0", symptom.getId());
	}
	
	@Test
	public void symptomResourceLoadSymptom(){
		
		LoadSymptomResource loadSymptomResource = new LoadSymptomResource(symptomAdapter);
		
		SymptomDTO symptomDTO = new SymptomDTO("0", "symptom");
		saveSymptomResource.saveSyptom(symptomDTO);
				
		String symptomId = "0";
		Symptom symptomLoaded = loadSymptomResource.loadSymptom(symptomId);
				
		Assert.assertEquals("symptom", symptomLoaded.getName());
	}
	
}
