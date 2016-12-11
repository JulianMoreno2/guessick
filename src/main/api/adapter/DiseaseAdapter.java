package adapter;

import domain.Disease;
import dto.DiseaseDTO;
import service.DiseaseService;

public class DiseaseAdapter {
	
	DiseaseService diseaseService;
	
	public DiseaseAdapter(DiseaseService diseaseService) {
		this.diseaseService = diseaseService;
	}

	public Disease saveDisease(DiseaseDTO diseaseDTO){
		
		//String id = diseaseDTO.getId();
		String name = diseaseDTO.getName();
		//Disease disease = new Disease(id, name);
		Disease disease = new Disease(name);
		
		this.diseaseService.saveDisease(disease);
		
		return disease;
	}
	
	public Disease loadDisease(String diseaseName) {
		return this.diseaseService.loadDisease(diseaseName);
	}
}
