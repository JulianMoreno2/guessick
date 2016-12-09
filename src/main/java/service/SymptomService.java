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
		repository.saveSymptom(symptom);
		symptom.getDiseases().stream().map(disease -> this.saveDisease(disease));
		return symptom;
	}

	private Disease saveDisease(Disease disease) {
		return repository.saveDisease(disease);
	}

	public Symptom loadSymptom(String symptomId) {
		return repository.loadSymptom(symptomId);
	}
}
