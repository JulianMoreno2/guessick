package resources;

import domain.Symptom;
import service.SymptomService;

public class SaveSymptomResource {
	
	SymptomService symptomService;

	public SaveSymptomResource(SymptomService symptomService) {
		this.symptomService = symptomService;
	}

	public Symptom saveSyptom(Symptom symptom) {		
		return this.symptomService.saveSymptom(symptom);
	}
}
