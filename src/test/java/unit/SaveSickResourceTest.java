package unit;

import org.junit.Test;

import adapter.SickAdapter;
import dto.SickDTO;
import repository.Repository;
import repository.MemoryRepository;
import resources.SaveSickResource;
import service.SickService;

public class SaveSickResourceTest {
	
	@Test
	public void sickResourceSaveSymptom(){
		//TODO: mock
		Repository sickRepository = new MemoryRepository();
		SickService sickService = new SickService(sickRepository);
		SickAdapter sickAdapter = new SickAdapter(sickService);
		SaveSickResource sickResource = new SaveSickResource(sickAdapter);
		
		SickDTO sickDTO = new SickDTO("1","symptom");
		sickResource.saveSyptom(sickDTO);
	}
}
