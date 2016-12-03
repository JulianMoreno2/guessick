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
		
		String id = diseaseDTO.getId();
		String name = diseaseDTO.getName();
		Disease disease = new Disease(id, name);
		
		this.diseaseService.saveDisease(disease);
		
		return disease;
	}
}
