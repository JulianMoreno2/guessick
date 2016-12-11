package service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.Disease;
import domain.Symptom;
import repository.Repository;

public class SymptomService {
	
	Repository repository;
	
	public SymptomService(Repository repository) {
		this.repository = repository;
	}

	public Symptom saveSymptom(Symptom symptom) {		
		repository.saveSymptom(symptom);
		//symptom.getDiseases().stream().map(disease -> this.saveDisease(disease));
		Map<String, Disease> symptomDiseases = symptom.getDiseases();
		Iterator<Disease> iterator = symptomDiseases.values().iterator();
		while(iterator.hasNext()){
			Disease currentDisease = iterator.next();
			this.saveDisease(currentDisease);
		}
		return symptom;
	}

	private Disease saveDisease(Disease disease) {
		return repository.saveDisease(disease);
	}
	
	public List<Symptom> loadAllSymptoms() {
		return repository.loadAllSymptoms();
	}
}
