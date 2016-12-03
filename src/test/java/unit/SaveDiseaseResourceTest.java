package unit;

import adapter.DiseaseAdapter;
import dto.DiseaseDTO;
import org.junit.Test;
import repository.MemoryRepository;
import repository.Repository;
import resources.SaveDiseaseResource;
import service.DiseaseService;

public class SaveDiseaseResourceTest {
	
	@Test
	public void sickResourceSaveSymptom(){
		//TODO: mock
		Repository diseaseRepository = new MemoryRepository();
		DiseaseService diseaseService = new DiseaseService(diseaseRepository);
		DiseaseAdapter diseaseAdapter = new DiseaseAdapter(diseaseService);
		SaveDiseaseResource diseaseResource = new SaveDiseaseResource(diseaseAdapter);
		
		DiseaseDTO diseaseDTO = new DiseaseDTO("1","symptom");
		diseaseResource.saveSyptom(diseaseDTO);
	}
}
