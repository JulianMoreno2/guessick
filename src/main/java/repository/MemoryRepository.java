package repository;

import domain.Disease;
import domain.Symptom;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemoryRepository implements Repository {
	
	List<Disease> diseases;
	List<Symptom> symptoms;
	
	public MemoryRepository(){
		diseases = new LinkedList<Disease>();
		symptoms = new LinkedList<Symptom>();
	}

	@Override
	public Disease saveDisease(Disease disease) {
		diseases.add(disease);
		return disease;
	}

	@Override
	public Symptom saveSymptom(Symptom symptom) {
		symptoms.add(symptom);
		return symptom;
	}

	@Override
	public Symptom loadSymptom(String symptomId) {		
		return symptoms.get(Integer.parseInt(symptomId));
	}

	@Override
	public Disease loadDisease(String diseaseId) {
		return diseases.get(Integer.parseInt(diseaseId));
	}
}
