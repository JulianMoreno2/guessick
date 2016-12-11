package core;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Disease;

public class Core {
	
	private ResourceContainer resourceContainer;

	public Core() {
		this.resourceContainer = new ResourceContainer();
	}

	/**
	 * ToDo: TEST
	 */
	public List<String> getPossibleDiseases(List<String> symptomsSelected){
		List<String> possibleDiseases = this.resourceContainer.getLoadPossibleDiseasesResource()
				.loadPossibleDiseases(symptomsSelected)
				.stream()
				.map(disease -> disease.getName())
				.collect(Collectors.toList());
		//List<String> possibleDiseases = new LinkedList<String>();
		//aca deberia haber logica
		possibleDiseases.add("Flu");
		possibleDiseases.add("Conjunctivitis");
		//
		return possibleDiseases;
	}

	/**
	 * ToDo: TEST
	 */
	public List<String> getDiseaseDetails(String diseaseSelected) {
		Disease disease = this.resourceContainer.getLoadDiseaseResource().loadDisease(diseaseSelected);
		List<String> diseaseDetails = new LinkedList<String>();
		//aca deberia haber logica
		diseaseDetails.add("Hacer reposo");
		diseaseDetails.add("Visitar al medico");
		//
		return diseaseDetails;
	}
	
}
