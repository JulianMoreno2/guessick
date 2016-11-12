package service;

import domain.Sick;
import domain.Symptom;
import repository.Repository;

public class SymptomService {
	
	Repository repository;
	
	public SymptomService(Repository repository) {
		this.repository = repository;
	}

	public Symptom saveSymptom(Symptom symptom) {		
		symptom.getSicks().stream().forEach(sick -> this.saveSick(sick));
		return symptom;
	}

	private Sick saveSick(Sick sick) {
		return repository.saveSick(sick);
	}
}
