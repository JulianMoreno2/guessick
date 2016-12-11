package repository;

import domain.Disease;
import domain.Symptom;

import java.util.List;

public interface Repository {

	Disease saveDisease(Disease disease);

	Symptom saveSymptom(Symptom symptom);

	Disease loadDisease(String disease);

	List<Disease> loadPossibleDiseases(List<String> symptomNames);

	List<Symptom> loadAllSymptoms();
}