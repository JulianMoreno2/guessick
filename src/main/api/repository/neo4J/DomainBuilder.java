package repository.neo4J;

import domain.Disease;
import domain.Symptom;

import java.util.LinkedList;
import java.util.List;

public class DomainBuilder {

    private Retriever retriever;

    public DomainBuilder() {
        this.retriever = new Retriever();
    }

    //Given a list of the symptom names, we build the model
    public List<Disease> buildDiseasesGivenSymptomNames(List<String> symptomsNames) {

        //First, we create all the symptom objects
        List<Symptom> symptoms = this.modelSymptomObjects(symptomsNames);

        //Then, we obtain from the database the names of all diseases that have those symptoms
        List<String> diseaseNames = this.retriever.retrieveDiseasesGivenTheseSymptoms(symptoms);
        List<Disease> diseases = this.modelDiseaseObjects(diseaseNames);
        return diseases;

    }

    public Disease buildDiseaseWithAllItsSymptoms(String diseaseName) {

    	if(diseaseName == "" || diseaseName == null){
    		return null;
    	}
    	
        Disease disease = new Disease(diseaseName);
        List<String> symptomNames = this.retriever.retrieveSymptomsFromAGivenDisease(disease);
        List<Symptom> symptoms = this.modelSymptomObjects(symptomNames);
        Disease fullDisease = this.assignSymptomsToDisease(disease, symptoms);
        return fullDisease;

    }

    private Disease assignSymptomsToDisease(Disease disease, List<Symptom> symptoms) {

        for (Symptom symptom : symptoms) {

            disease.addSymptom(symptom);

        }
        return disease;

    }

    private List<Disease> modelDiseaseObjects(List<String> diseaseNames) {

        List<Disease> diseases = new LinkedList<Disease>();
        for (String diseaseName : diseaseNames) {

            Disease disease = new Disease(diseaseName);
            diseases.add(disease);

        }

        return diseases;

    }

    public List<Symptom> modelSymptomObjects(List<String> symptomNames) {

        List<Symptom> symptoms = new LinkedList<Symptom>();
        for (String symptomName : symptomNames) {

            Symptom symptom = new Symptom(symptomName);
            symptoms.add(symptom);

        }

        return symptoms;

    }

    public List<Symptom> buildAllSymptoms() {

        List<String> symptomNames = this.retriever.retrieveAllSymptoms();
        List<Symptom> symptoms = this.modelSymptomObjects(symptomNames);
        return symptoms;

    }
}
