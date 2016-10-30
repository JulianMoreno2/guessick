package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Sick;
import domain.Symptom;


public class SickTest {

	Sick sick;
	
	@Before
	public void doBefore(){
		sick = new Sick("1", "sick");
	}
	
	@Test
	public void sickCreateWithIdAndName(){		
		Assert.assertEquals("1", sick.getId());
		Assert.assertEquals("sick", sick.getName());
	}
	
	@Test
	public void sickAddASymptom(){
		//Dado
		Symptom symptom = new Symptom("1", "sick");
		//Cuando
		sick.addSymptom(symptom);
		//Entonces
		Assert.assertEquals(Symptom.class, sick.getSymptoms().get(0).getClass());
		
	}
}
