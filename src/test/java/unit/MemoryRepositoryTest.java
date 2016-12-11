package unit;

import org.junit.Test;

import domain.Disease;
import domain.Symptom;

import org.junit.Assert;
import org.junit.Before;

import repository.MemoryRepository;
import repository.Repository;
import static org.mockito.Mockito.*;

import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
import java.util.Map;

public class MemoryRepositoryTest {
	
	private Disease flu;
	private Repository repository;
	private Symptom fever;
	
	@Before
	public void doBefore(){
		repository = new MemoryRepository();
		
		flu = mock(Disease.class);
		fever = mock(Symptom.class);
		
		//List<Disease> listSicksForFever = new LinkedList<Disease>();
		//listSicksForFever.add(flu);
		Map<String, Disease> listDiseasesForFever = new HashMap<String, Disease>();
		listDiseasesForFever.put("1", flu);
		
		//List<Symptom> listSymptomsForFlu = new LinkedList<Symptom>();
		Map<String, Symptom> listSymptomsForFlu = new HashMap<String, Symptom>();
		listSymptomsForFlu.put("0", fever);//listSymptomsForFlu.add(fever);
		
		//when(flu.getId()).thenReturn("1");
		when(flu.getName()).thenReturn("gripe");
		when(flu.getSymptoms()).thenReturn(listSymptomsForFlu);		
		
		//when(fever.getId()).thenReturn("0");
		when(fever.getName()).thenReturn("fiebre");
		when(fever.getDiseases()).thenReturn(listDiseasesForFever);
	}
	
	@Test
	public void saveSickInListCorrectly(){
		Assert.assertEquals(flu, repository.saveDisease(flu));		
	}
	
	@Test
	public void saveSymptomInListCorrectly(){
		Assert.assertEquals(fever, repository.saveSymptom(fever));
	}
	
	@Test
	public void loadDiseaseCorrectly(){
		repository.saveDisease(flu);
		Assert.assertEquals("gripe", repository.loadDisease("gripe").getName());
}
}
