package service;

import domain.Sick;
import domain.Symptom;
import repository.Repository;

public class SickService {

	Repository repository;
	
	public SickService(Repository repository) {
		this.repository = repository;
	}

	public Sick saveSick(Sick sick) {				
		sick.getSymptoms().stream().forEach(symptom -> this.saveSymptom(symptom));
		return repository.saveSick(sick);	
	}

	private Symptom saveSymptom(Symptom symptom) {
		return repository.saveSymptom(symptom);
	}
}
