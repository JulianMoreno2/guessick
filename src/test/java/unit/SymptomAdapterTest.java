package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adapter.SymptomAdapter;
import domain.Symptom;
import dto.SymptomDTO;
import repository.Repository;
import service.SymptomService;

public class SymptomAdapterTest {

	Repository symptomRepository;
	SymptomService symptomService;
	SymptomAdapter symptomAdapter;
	
	@Before
	public void doBefore(){
		
		symptomRepository = Given.giveMemoryRepository();
		symptomService = new SymptomService(symptomRepository);
		symptomAdapter = new SymptomAdapter(symptomService);	
	}
		
	@Test
	public void saveSymptomAdapter(){
		SymptomDTO symptomDTO = Given.giveSymptomDTO();
		Symptom symptom = symptomAdapter.saveSymptom(symptomDTO);
		
		Assert.assertEquals("symptomDTO", symptom.getName());
	}
	
	@Test
	public void loadSymptomAdapter(){

		SymptomDTO symptomDTO = Given.giveSymptomDTO();
		symptomAdapter.saveSymptom(symptomDTO);
		
		String symptomName = "symptomDTO";
		Assert.assertEquals(symptomName, symptomAdapter.loadSymptom(symptomName).getName());
	}
}
	
