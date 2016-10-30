package unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Sick;
import domain.Symptom;


public class SymptomTest {
	
	private Symptom fever;
	private Sick flu;
	private Sick ebola;
	
	@Before
	public void doBefore(){
		fever = new Symptom("1","fever");
		flu = new Sick("1", "flu"); 
		ebola = new Sick("2", "ebola");
	}
	
	@Test
	public void symptomCreateWithIdAndName(){
		Assert.assertEquals("1", fever.getId());
		Assert.assertEquals("fever", fever.getName());
	}
	
	@Test
	public void symptomAddSickToItsList(){
		//Cuando
		fever.addSick(flu);
		//Entonces
		Assert.assertEquals(Sick.class, fever.getSicks().get(0).getClass());
	}
	
	@Test
	public void symptomAddSickAndSickAddTheSameSymptom(){
		//Cuando
		fever.addSick(ebola);
		//Entonces
		Assert.assertEquals("fever", ebola.getSymptoms().get(0).getName());
	}

}
