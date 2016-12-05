package unit;

import org.junit.Assert;
import org.junit.Test;

import adapter.SymptomAdapter;
import domain.Disease;
import domain.Symptom;
import dto.DiseaseDTO;
import dto.SymptomDTO;
import repository.MemoryRepository;
import repository.Repository;
import service.SymptomService;

public class SymptomAdapterTest {

	@Test
	public void saveSymptomAdapter(){
		//TODO: mock
		Repository symptomRepository = Given.giveMemoryRepository();		
		SymptomService symptomService = new SymptomService(symptomRepository);
		SymptomAdapter symptomAdapter = new SymptomAdapter(symptomService);
		
		SymptomDTO symptomDTO = Given.giveSymptomDTO();
		Symptom symptom = symptomAdapter.saveSymptom(symptomDTO);
		
		Assert.assertEquals("1", symptom.getId());
	}
}
	
