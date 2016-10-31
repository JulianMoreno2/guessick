package unit;

import org.junit.Test;

import adapter.SickAdapter;
import dto.SickDTO;
import repository.SickRepository;
import resources.SickResource;
import service.SickService;

public class SaveSickResourceTest {
	
	@Test
	public void sickResourceSaveSymptom(){
		//TODO: mock
		SickRepository sickRepository = new SickRepository();
		SickService sickService = new SickService(sickRepository);
		SickAdapter sickAdapter = new SickAdapter(sickService);
		SickResource sickResource = new SickResource(sickAdapter);
		
		SickDTO sickDTO = new SickDTO("1","symptom");
		sickResource.saveSyptom(sickDTO);
	}
}
