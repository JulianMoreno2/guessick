package repository;

import domain.Disease;
import domain.Symptom;

import java.util.LinkedList;
import java.util.List;

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
}
