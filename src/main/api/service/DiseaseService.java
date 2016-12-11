package service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.Disease;
import domain.Symptom;
import repository.Repository;

public class DiseaseService {

	Repository repository;
	
	public DiseaseService(Repository repository) {
		this.repository = repository;
	}

	public Disease saveDisease(Disease disease) {
		//disease.getSymptoms().stream().forEach(symptom -> this.saveSymptom(symptom));
		Map<String, Symptom> diseaseSymptoms = disease.getSymptoms();
		Iterator<Symptom> iterator = diseaseSymptoms.values().iterator();
		while(iterator.hasNext()){
			Symptom currentSymptom = iterator.next();
			this.saveSymptom(currentSymptom);
		}
		return repository.saveDisease(disease);
	}

	private Symptom saveSymptom(Symptom symptom) {
		return repository.saveSymptom(symptom);
	}
	
	public Disease loadDisease(String diseaseName) {
		return repository.loadDisease(diseaseName);
	}

	public List<Disease> loadPossibleDiseases(List<String> nameSymptoms) {
		return repository.loadPossibleDiseases(nameSymptoms);
	}
}
