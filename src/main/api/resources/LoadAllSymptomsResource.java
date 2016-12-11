package resources;

import java.util.List;

import domain.Symptom;
import service.SymptomService;

public class LoadAllSymptomsResource {

	SymptomService symptomService;

	public LoadAllSymptomsResource(SymptomService symptomService) {
		this.symptomService = symptomService;
	}
	
	public List<Symptom> loadAllSymptoms(){
		return this.symptomService.loadAllSymptoms();
	}
}
