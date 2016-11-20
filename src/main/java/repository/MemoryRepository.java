package repository;

import java.util.LinkedList;
import java.util.List;

import domain.Sick;
import domain.Symptom;

public class MemoryRepository implements Repository {
	
	List<Sick> sicks;
	List<Symptom> symptoms;
	
	public MemoryRepository(){
		sicks = new LinkedList<Sick>();
		symptoms = new LinkedList<Symptom>();
	}

	@Override
	public Sick saveSick(Sick sick) {
		sicks.add(sick);
		return sick;
	}

	@Override
	public Symptom saveSymptom(Symptom symptom) {
		symptoms.add(symptom);
		return symptom;
	}
}
