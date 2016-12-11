package core;

import java.util.LinkedList;
import java.util.List;

public class Core {
	/**
	 * ToDo: TEST
	 */
	public List<String> getPossibleDiseases(List<String> symptomsSelected){
		List<String> possibleDiseases = new LinkedList<String>();
		//aca deberia haber logica
		possibleDiseases.add("Flu");
		possibleDiseases.add("Conjunctivitis");
		//
		return possibleDiseases;
	}

	public List<String> getDiseaseDetails(String disease_selected) {
		List<String> diseaseDetails = new LinkedList<String>();
		//aca deberia haber logica
		diseaseDetails.add("Hacer reposo");
		diseaseDetails.add("Visitar al medico");
		//
		return diseaseDetails;
	}
	
}
