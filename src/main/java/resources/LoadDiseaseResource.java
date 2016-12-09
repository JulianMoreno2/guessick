package resources;

import adapter.DiseaseAdapter;
import domain.Disease;

public class LoadDiseaseResource {

	DiseaseAdapter diseaseAdapter;

	public LoadDiseaseResource(DiseaseAdapter diseaseAdapter) {
		this.diseaseAdapter = diseaseAdapter;
	}

	public Disease loadDisease(String diseaseId) {		
		return this.diseaseAdapter.loadDisease(diseaseId);
	}

}
