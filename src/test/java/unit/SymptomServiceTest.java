package unit;

import org.junit.Assert;
import org.junit.Test;

import domain.Disease;
import domain.Symptom;
import repository.MemoryRepository;
import repository.Repository;
import service.SymptomService;

public class SymptomServiceTest {

	@Test
	public void saveSymptom(){
		//TODO: mock
		Repository symptomRepository = Given.giveMemoryRepository();
		
		SymptomService symptomService = new SymptomService(symptomRepository);
		
		Symptom symptomSaved = Given.giveSymptom();
		Symptom symptom = symptomService.saveSymptom(symptomSaved);
		
		Assert.assertEquals(symptomSaved.getId(), symptom.getId());
	}
	
}
