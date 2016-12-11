package repository;

import domain.Disease;
import domain.Symptom;
import repository.neo4J.DomainBuilder;

import java.util.List;

public class NeoFourJRepository implements Repository{

    private DomainBuilder builder = new DomainBuilder();

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
	public Disease loadDisease(String diseaseName) {

        return this.builder.buildDiseaseWithAllItsSymptoms(diseaseName);

	}

	@Override
	public List<Disease> loadPossibleDiseases(List<String> symptomNames) {

		return this.builder.buildDiseasesGivenSymptomNames(symptomNames);

	}

	@Override
	public List<Symptom> loadAllSymptoms() {
		// TODO Auto-generated method stub
		return null;
	}

}
