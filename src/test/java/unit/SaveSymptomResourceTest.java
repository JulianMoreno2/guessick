package unit;

import org.junit.Test;

import adapter.SymptomAdapter;
import dto.SymptomDTO;
import repository.Repository;
import resources.SymptomResource;
import service.SymptomService;

public class SaveSymptomResourceTest {

	@Test
	public void symptomResourceSaveSymptom(){
		//TODO: mock
		Repository symptomRepository = new Repository();
		SymptomService symptomService = new SymptomService(symptomRepository);
		SymptomAdapter symptomAdapter = new SymptomAdapter(symptomService);
		SymptomResource symptomResource = new SymptomResource(symptomAdapter);
		
		SymptomDTO symptomDTO = new SymptomDTO("1","symptom");
		symptomResource.saveSyptom(symptomDTO);
	}
	
}
