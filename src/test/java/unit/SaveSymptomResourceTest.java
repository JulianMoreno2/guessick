package unit;

import org.junit.Test;

import adapter.SymptomAdapter;
import dto.SymptomDTO;
import repository.SymptomRepository;
import resources.SymptomResource;
import service.SymptomService;

public class SaveSymptomResourceTest {

	@Test
	public void symptomResourceSaveSymptom(){
		//TODO: mock
		SymptomRepository symptomRepository = new SymptomRepository();
		SymptomService symptomService = new SymptomService(symptomRepository);
		SymptomAdapter symptomAdapter = new SymptomAdapter(symptomService);
		SymptomResource symptomResource = new SymptomResource(symptomAdapter);
		
		SymptomDTO symptomDTO = new SymptomDTO("1","symptom");
		symptomResource.saveSyptom(symptomDTO);
	}
	
}
