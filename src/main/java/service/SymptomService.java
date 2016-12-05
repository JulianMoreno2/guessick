package service;

import domain.Disease;
import domain.Symptom;
import repository.Repository;

public class SymptomService {
	
	Repository repository;
	
	public SymptomService(Repository repository) {
		this.repository = repository;
	}

	public Symptom saveSymptom(Symptom symptom) {		
		symptom.getSicks().stream().forEach(disease -> this.saveDisease(disease));
		return symptom;
	}

	private Disease saveDisease(Disease disease) {
		return repository.saveDisease(disease);
	}
}
