package repository.neo4J;

import domain.Disease;
import domain.Symptom;
import org.neo4j.driver.v1.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Retriever {

    private Session session;
    
    public List<String> retrieveDiseasesGivenTheseSymptoms(List<Symptom> symptoms) {

        this.initializeSession();

        /*The algorythm is: for EACH symptom in the list,
        we retrieve ALL diseases that show it;
        then we do the intersection between the results
         */

        List<Set<String>> listOfDiseaseSets = new LinkedList<Set<String>>();
        for (int i=0; i < symptoms.size(); i++) {

            Set<String> diseaseNames = new HashSet<String>();
            Symptom symptom = symptoms.get(i);

            String symptomID = this.retrieveSymptomId(symptom).toString();
            String query = "START a=node(" + symptomID + ") MATCH (a)-[:is_in*]->(b) RETURN distinct b.name AS name";
            StatementResult result = this.session.run(query);
            while(result.hasNext()){

                Record record = result.next();
                diseaseNames.add(record.get("name").asString());

            }

        }

        Set<String> diseaseNames = listOfDiseaseSets.get(0);
        for(int i=1; i < listOfDiseaseSets.size(); i++) { //This starts at 1 because we have a copy of its number 0 set

            diseaseNames.retainAll(listOfDiseaseSets.get(i)); //We intersect our copy with every other disease set

        }

        if (diseaseNames.isEmpty()) {

            //TODO: Tell the user that no diseases were found that match all his symptoms, and stop the execution of this function

        }

        List<String> diseases = new LinkedList<String>();
        for (String disease : diseaseNames) {

            diseases.add(disease);
        }

        return diseases;

    }

    private Integer retrieveSymptomId(Symptom symptom) {

        String symptomName = symptom.getName();
        String nodeName = symptom.getDBNodeName();

        String query = "MATCH (" + nodeName + ": " + symptomName + ") WHERE " + nodeName + ".name = '" + symptomName + "' RETURN ID(" + nodeName + ") AS id";

        StatementResult idResult = this.session.run(query);
        Record record = idResult.next();
        return record.get("id").asInt();

    }

    private void initializeSession() {

        Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "1234"));
        this.session = driver.session();

    }

    public List<String> retrieveSymptomsFromAGivenDisease(Disease disease) {

        this.initializeSession();
        String diseaseID = this.retrieveDiseaseId(disease).toString();

        String query = "START a=node(" + diseaseID + ") MATCH (a)-[:has*]->(b) RETURN distinct b.name AS name";
        StatementResult result = this.session.run(query);
        List<String> symptomNames = new LinkedList<String>();
        while(result.hasNext()){

            Record record = result.next();
            symptomNames.add(record.get("name").asString());

        }
        return symptomNames;

    }

    private Integer retrieveDiseaseId(Disease disease) {

        String diseaseName = disease.getName();
        String nodeName = disease.getDBNodeName();

        String query = "MATCH (" + nodeName + ": " + diseaseName + ") WHERE " + nodeName + ".name = '" + diseaseName + "' RETURN ID(" + nodeName + ") AS id";

        StatementResult idResult = this.session.run(query);
        Record record = idResult.next();
        return record.get("id").asInt();

    }
}
