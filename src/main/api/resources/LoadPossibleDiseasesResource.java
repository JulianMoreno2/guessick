package resources;

import java.util.List;

import domain.Disease;
import service.DiseaseService;

public class LoadPossibleDiseasesResource {

	DiseaseService diseaseService;

	public LoadPossibleDiseasesResource(DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

	public List<Disease> loadPossibleDiseases(List<String> nameSymptoms) {		
		return this.diseaseService.loadPossibleDiseases(nameSymptoms);
	}

}
