package resources;

import domain.Symptom;
import service.SymptomService;

public class LoadSymptomResource {
	
	SymptomService symptomService;

	public LoadSymptomResource(SymptomService symptomService) {
		this.symptomService = symptomService;
	}

	public Symptom loadSymptom(String symptomName) {		
		return this.symptomService.loadSymptom(symptomName);
	}
}
