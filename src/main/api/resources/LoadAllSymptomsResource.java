package resources;

import service.SymptomService;

public class LoadAllSymptomsResource {

	SymptomService symptomService;

	public LoadAllSymptomsResource(SymptomService symptomService) {
		this.symptomService = symptomService;
	}
}
