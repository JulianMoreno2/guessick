package core;

import repository.NeoFourJRepository;
import repository.Repository;
import resources.LoadAllSymptomsResource;
import resources.LoadDiseaseResource;
import resources.LoadPossibleDiseasesResource;
import service.DiseaseService;
import service.SymptomService;

public class ResourceContainer {
	
	private Repository neoFourJRepository;
	private LoadAllSymptomsResource loadAllSymptomsResource;
	private LoadDiseaseResource loadDiseaseResource;
	private LoadPossibleDiseasesResource loadPossibleDiseaseResource;
	
	public ResourceContainer(){
		
		neoFourJRepository = new NeoFourJRepository();
		SymptomService symptomService = new SymptomService(neoFourJRepository);	
		this.loadAllSymptomsResource = new LoadAllSymptomsResource(symptomService);
		
		DiseaseService diseaseService = new DiseaseService(neoFourJRepository);
		this.loadDiseaseResource = new LoadDiseaseResource(diseaseService);
		this.loadPossibleDiseaseResource = new LoadPossibleDiseasesResource(diseaseService);
		
	}

	public LoadAllSymptomsResource getLoadAllSymptomsResource() {
		return this.loadAllSymptomsResource;		
	}
	
	public LoadPossibleDiseasesResource getLoadPossibleDiseasesResource(){
		return this.loadPossibleDiseaseResource;
	}

	public LoadDiseaseResource getLoadDiseaseResource() {
		return this.loadDiseaseResource;
	}
	
}
