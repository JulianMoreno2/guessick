package unit;

import org.junit.Test;
import org.junit.Assert;

import adapter.SymptomAdapter;
import domain.Symptom;
import dto.SymptomDTO;
import repository.Repository;
import resources.SaveSymptomResource;
import service.SymptomService;

public class SaveSymptomResourceTest {

	@Test
	public void symptomResourceSaveSymptom(){
		//TODO: mock
		Repository repository = Given.giveMemoryRepository();
		SymptomService symptomService = new SymptomService(repository);
		SymptomAdapter symptomAdapter = new SymptomAdapter(symptomService);
		SaveSymptomResource symptomResource = new SaveSymptomResource(symptomAdapter);
		
		SymptomDTO symptomDTO = new SymptomDTO("1","symptom");
		Symptom symptom = symptomResource.saveSyptom(symptomDTO);
		
		Assert.assertEquals("1", symptom.getId());
	}
	
}
