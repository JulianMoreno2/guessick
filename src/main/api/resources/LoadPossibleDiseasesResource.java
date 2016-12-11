package resources;

import java.util.List;
import java.util.Set;

import domain.Disease;
import service.DiseaseService;

public class LoadPossibleDiseasesResource {

	DiseaseService diseaseService;

	public LoadPossibleDiseasesResource(DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

	public List<Disease> loadPossibleDiseases(Set<String> nameSymptoms) {		
		return this.diseaseService.loadPossibleDiseases(nameSymptoms);
	}

}
