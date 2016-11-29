package resources;

import adapter.DiseaseAdapter;
import domain.Disease;
import dto.DiseaseDTO;

public class SaveDiseaseResource {
	
	private DiseaseAdapter diseaseAdapter;

	public SaveDiseaseResource(DiseaseAdapter diseaseAdapter) {
		this.diseaseAdapter = diseaseAdapter;
	}

	public Disease saveSyptom(DiseaseDTO diseaseDTO) {
		Disease disease = this.diseaseAdapter.saveDisease(diseaseDTO);
		return disease;
	}
}
