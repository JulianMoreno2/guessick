package repository;

import domain.Disease;
import domain.Symptom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryRepository implements Repository {
	
	Map<String, Disease> diseases;
	//List<Disease> diseases; the map had the same implementation (a list was used) before
	Map <String, Symptom> symptoms;
	
	public MemoryRepository(){
		//diseases = new LinkedList<Disease>();
		diseases = new HashMap<String, Disease>();
		symptoms = new HashMap<String, Symptom>();
	}

	@Override
	public Disease saveDisease(Disease disease) {
		//diseases.add(disease);
		String diseaseName = disease.getName();
		diseases.put(diseaseName, disease);
		return disease;
	}

	@Override
	public Symptom saveSymptom(Symptom symptom) {
		String symptomName = symptom.getName();
		symptoms.put(symptomName, symptom);
		return symptom;
	}

	@Override
	public Disease loadDisease(String diseaseName) {
		return diseases.get(diseaseName);
	}

	@Override
	public List<Disease> loadPossibleDiseases(List<String> nameSymptoms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Symptom> loadAllSymptoms() {
		// TODO Auto-generated method stub
		return null;
	}
}
