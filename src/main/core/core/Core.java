package core;

import java.util.List;
import java.util.Set;
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
	public List<String> getPossibleDiseases(Set<String> symptomsSelected){
		List<String> possibleDiseases = this.resourceContainer.getLoadPossibleDiseasesResource()
				.loadPossibleDiseases(symptomsSelected)
				.stream()
				.map(disease -> disease.getName())
				.collect(Collectors.toList());
		return possibleDiseases;
	}

	/**
	 * ToDo: TEST
	 */
	public Set<String> getDiseaseDetails(String diseaseSelected) {
		if(diseaseSelected == "" || diseaseSelected == null){
			return null;
		}
		Disease disease = this.resourceContainer.getLoadDiseaseResource().loadDisease(diseaseSelected);
		return disease.getSymptoms().keySet();
	}
	
	/**
	 * ToDo: TEST
	 */
	public List<String> getAllSymptoms() {
		return this.resourceContainer.getLoadAllSymptomsResource()
				.loadAllSymptoms()
				.stream()
				.map(symptom -> symptom.getName())
				.collect(Collectors.toList());
	}
	
}
