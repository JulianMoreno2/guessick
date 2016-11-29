package service;

import domain.Disease;
import domain.Symptom;
import repository.Repository;

public class DiseaseService {

	Repository repository;
	
	public DiseaseService(Repository repository) {
		this.repository = repository;
	}

	public Disease saveDisease(Disease disease) {
		disease.getSymptoms().stream().forEach(symptom -> this.saveSymptom(symptom));
		return repository.saveDisease(disease);
	}

	private Symptom saveSymptom(Symptom symptom) {
		return repository.saveSymptom(symptom);
	}
}
