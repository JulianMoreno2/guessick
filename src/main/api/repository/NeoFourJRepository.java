package repository;

import java.util.List;
import java.util.Set;

import domain.Disease;
import domain.Symptom;

public class NeoFourJRepository implements Repository{

	@Override
	public Disease saveDisease(Disease disease) {
		// TODO Auto-generated method stub
		//  TODO: saveSick(SickDAO sickDAO) 
		// -> dao = Data Access Object for save in Neo4J DataBase
		return null;
	}

    @Override
	public Symptom saveSymptom(Symptom symptom) {
		// TODO Auto-generated method stub
		//  TODO: saveSick(SickDAO sickDAO) 
		// -> dao = Data Access Object for save in Neo4J DataBase		
		return null;
	}

	@Override
	public Disease loadDisease(String diseaseId) {
		// TODO Auto-generated method stub
		return null;
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
