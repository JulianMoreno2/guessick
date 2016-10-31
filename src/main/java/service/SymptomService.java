package service;

import domain.Symptom;
import repository.SymptomRepository;

public class SymptomService {

	SymptomRepository symptomRepository;
	
	public SymptomService(SymptomRepository symptomRepository) {
		this.symptomRepository = symptomRepository;
	}

	public void saveSymptom(Symptom symptom) {
		this.symptomRepository.saveSymptom(symptom);
	}

}
