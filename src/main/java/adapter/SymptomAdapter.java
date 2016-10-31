package adapter;

import domain.Symptom;
import dto.SymptomDTO;
import service.SymptomService;

public class SymptomAdapter {

	SymptomService symptomService;
	
	public SymptomAdapter(SymptomService symptomService) {
		this.symptomService = symptomService;
	}

	public Symptom saveSymptom(SymptomDTO symptomDTO) {
		String id = symptomDTO.getId();
		String name = symptomDTO.getName();
		Symptom symptom = new Symptom(id, name);
		
		this.symptomService.saveSymptom(symptom);
		
		return symptom;
	}

}
