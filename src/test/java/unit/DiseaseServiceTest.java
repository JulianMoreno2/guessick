package unit;

import org.junit.Assert;
import org.junit.Test;

import domain.Disease;
import repository.Repository;
import service.DiseaseService;

public class DiseaseServiceTest {

	@Test
	public void saveSick(){
		
		Repository sickRepository = Given.giveMemoryRepository();
		DiseaseService diseaseService = new DiseaseService(sickRepository);
		Disease diseaseSaved = Given.giveDisease();
		Disease disease = diseaseService.saveDisease(diseaseSaved);
		
		Assert.assertEquals(diseaseSaved.getName(), disease.getName());
	}
}
