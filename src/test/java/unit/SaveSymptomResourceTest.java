package unit;

import org.junit.Test;

import adapter.SymptomAdapter;
import dto.SymptomDTO;
import repository.MemoryRepository;
import repository.Repository;
import resources.SaveSymptomResource;
import service.SymptomService;

public class SaveSymptomResourceTest {

	@Test
	public void symptomResourceSaveSymptom(){
		//TODO: mock
		Repository symptomRepository = new MemoryRepository();
		SymptomService symptomService = new SymptomService(symptomRepository);
		SymptomAdapter symptomAdapter = new SymptomAdapter(symptomService);
		SaveSymptomResource symptomResource = new SaveSymptomResource(symptomAdapter);
		
		SymptomDTO symptomDTO = new SymptomDTO("1","symptom");
		symptomResource.saveSyptom(symptomDTO);
	}
	
}
