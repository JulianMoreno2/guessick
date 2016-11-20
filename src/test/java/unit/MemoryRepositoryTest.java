package unit;

import org.junit.Test;

import domain.Sick;
import domain.Symptom;

import org.junit.Assert;
import org.junit.Before;

import repository.MemoryRepository;
import repository.Repository;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

public class MemoryRepositoryTest {
	
	private Sick flu;
	private Repository repository;
	private Symptom fever;
	
	@Before
	public void doBefore(){
		repository = new MemoryRepository();
		
		flu = mock(Sick.class);
		fever = mock(Symptom.class);
		
		List<Sick> listSicksForFever = new LinkedList<Sick>();
		listSicksForFever.add(flu);
		
		List<Symptom> listSymptomsForFlu = new LinkedList<Symptom>();
		listSymptomsForFlu.add(fever);
		
		when(flu.getId()).thenReturn("1");
		when(flu.getName()).thenReturn("gripe");
		when(flu.getSymptoms()).thenReturn(listSymptomsForFlu);		
		
		when(fever.getId()).thenReturn("1");
		when(fever.getName()).thenReturn("fiebre");
		when(fever.getSicks()).thenReturn(listSicksForFever);
	}
	
	@Test
	public void saveSickInListCorrectly(){
		Assert.assertEquals(flu, repository.saveSick(flu));		
	}
	
	@Test
	public void saveSymptomInListCorrectly(){
		Assert.assertEquals(fever, repository.saveSymptom(fever));
	}


}
