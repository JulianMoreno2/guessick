package repository;

import domain.Disease;
import domain.Symptom;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemoryRepository implements Repository {
	
	List<Disease> diseases;
	Map <String, Symptom> symptoms;
	
	public MemoryRepository(){
		diseases = new LinkedList<Disease>();
		symptoms = new HashMap<String, Symptom>();
	}

	@Override
	public Disease saveDisease(Disease disease) {
		diseases.add(disease);
		return disease;
	}

	@Override
	public Symptom saveSymptom(Symptom symptom) {
		String symptomName = symptom.getName();
		symptoms.put(symptomName, symptom);
		return symptom;
	}

	@Override
	public Symptom loadSymptom(String symptomName) {		
		return symptoms.get(symptomName);
	}

	@Override
	public Disease loadDisease(String diseaseId) {
		return diseases.get(Integer.parseInt(diseaseId));
	}
}
