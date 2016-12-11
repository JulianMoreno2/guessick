package resources;

import adapter.SymptomAdapter;
import domain.Symptom;
import dto.SymptomDTO;

public class SaveSymptomResource {
	
	SymptomAdapter symptomAdapter;

	public SaveSymptomResource(SymptomAdapter symptomAdapter) {
		this.symptomAdapter = symptomAdapter;
	}

	public Symptom saveSyptom(SymptomDTO symptomDTO) {		
		Symptom symptom = this.symptomAdapter.saveSymptom(symptomDTO);
		return symptom;
	}
}
