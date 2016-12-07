package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Symptom;
import repository.Repository;
import service.SymptomService;

public class SymptomServiceTest {
	
	Repository symptomRepository;
	SymptomService symptomService;
	
	@Before
	public void doBefore(){
		symptomRepository = Given.giveMemoryRepository();
		symptomService = new SymptomService(symptomRepository);
		
	}

	@Test
	public void saveSymptomTest(){
				
		Symptom symptomSaved = new Symptom("1", "symptom");
		Symptom symptom = symptomService.saveSymptom(symptomSaved);
		
		Assert.assertEquals(symptomSaved.getId(), symptom.getId());
	}
	
	@Test
	public void loadSymptomTest(){
		
		Symptom symptomSaved = new Symptom("1", "symptom");
		symptomService.saveSymptom(symptomSaved);
		
		String symptomId = "1";
		
		Assert.assertEquals(symptomSaved.getId(), symptomService.loadSymptom(symptomId).getId());
	}
	
}
