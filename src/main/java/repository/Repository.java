package repository;

import domain.Sick;
import domain.Symptom;

public interface Repository {

	Sick saveSick(Sick sick);

	Symptom saveSymptom(Symptom symptom);

}