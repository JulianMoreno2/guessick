package repository;

import java.util.List;

import domain.Disease;
import domain.Symptom;

public interface Repository {

	Disease saveDisease(Disease disease);

	Symptom saveSymptom(Symptom symptom);

	Symptom loadSymptom(String symptomId);

	Disease loadDisease(String disease);

	List<Disease> loadPossibleDiseases(List<String> nameSymptoms);
}