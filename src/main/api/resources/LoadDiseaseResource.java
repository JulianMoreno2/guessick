package resources;

import domain.Disease;
import service.DiseaseService;

public class LoadDiseaseResource {

	DiseaseService diseaseService;

	public LoadDiseaseResource(DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

	public Disease loadDisease(String diseaseName) {		
		return this.diseaseService.loadDisease(diseaseName);
	}

}
