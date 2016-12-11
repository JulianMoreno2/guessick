package repository;

import domain.Disease;
import domain.Symptom;
import repository.neo4J.DomainBuilder;

import java.util.List;

public class NeoFourJRepository implements Repository{

    private DomainBuilder builder;

    public NeoFourJRepository() {

        this.builder = new DomainBuilder();
    }

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
	public Symptom loadSymptom(String symptomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disease loadDisease(String diseaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disease> loadPossibleDiseases(List<String> symptomNames) {

        return this.builder.buildDiseasesGivenSymptomNames(symptomNames);

	}

}
