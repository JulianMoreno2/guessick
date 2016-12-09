package unit;

import domain.Disease;
import domain.Symptom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DiseaseTest {

	Disease disease;
	
	@Before
	public void doBefore(){
		disease = new Disease("1", "disease");
	}
	
	@Test
	public void createDiseaseWithIdAndName(){
		Assert.assertEquals("1", disease.getId());
		Assert.assertEquals("disease", disease.getName());
	}
	
	@Test
	public void addASymptom(){
		//Dado
		Symptom symptom = new Symptom("symptom");
		//Cuando
		disease.addSymptom(symptom);
		//Entonces
		Assert.assertEquals(Symptom.class, disease.getSymptoms().get("symptom").getClass());
	}
}
