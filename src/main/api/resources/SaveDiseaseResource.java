package resources;

import domain.Disease;
import service.DiseaseService;

public class SaveDiseaseResource {
	
	private DiseaseService diseaseService;

	public SaveDiseaseResource(DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

	public Disease saveDisease(Disease disease) {
		return this.diseaseService.saveDisease(disease);
	}
}
