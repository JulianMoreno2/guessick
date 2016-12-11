package repository;

import java.util.List;
import java.util.Set;

import domain.Disease;
import domain.Symptom;

public interface Repository {

	Disease saveDisease(Disease disease);

	Symptom saveSymptom(Symptom symptom);

	Symptom loadSymptom(String symptomId);

	Disease loadDisease(String disease);

	List<Disease> loadPossibleDiseases(Set<String> nameSymptoms);

	List<Symptom> loadAllSymptoms();
}