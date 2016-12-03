package unit;

import domain.Disease;
import domain.Symptom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SymptomTest {
	
	private Symptom fever;
	private Disease flu;
	private Disease ebola;
	
	@Before
	public void doBefore(){
		fever = new Symptom("1","fever");
		flu = new Disease("1", "flu");
		ebola = new Disease("2", "ebola");
	}
	
	@Test
	public void symptomCreateWithIdAndName(){
		Assert.assertEquals("1", fever.getId());
		Assert.assertEquals("fever", fever.getName());
	}
	
	@Test
	public void symptomAddDiseaseToItsList(){
		//Cuando
		fever.addDisease(flu);
		//Entonces
		Assert.assertEquals(Disease.class, fever.getSicks().get(0).getClass());
	}
	
	@Test
	public void symptomAddSickAndDiseaseAddTheSameSymptom(){
		//Cuando
		fever.addDisease(ebola);
		//Entonces
		Assert.assertEquals("fever", ebola.getSymptoms().get(0).getName());
	}

}
