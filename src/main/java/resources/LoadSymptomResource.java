package resources;

import adapter.SymptomAdapter;
import domain.Symptom;

public class LoadSymptomResource {
	
	SymptomAdapter symptomAdapter;

	public LoadSymptomResource(SymptomAdapter symptomAdapter) {
		this.symptomAdapter = symptomAdapter;
	}

	public Symptom loadSymptom(String symptomId) {		
		return this.symptomAdapter.loadSymptom(symptomId);
	}
}
