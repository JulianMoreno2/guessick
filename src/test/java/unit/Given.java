package unit;

import domain.Disease;
import domain.Symptom;
import dto.DiseaseDTO;
import dto.SymptomDTO;
import repository.MemoryRepository;
import repository.Repository;

public class Given {
	
	private static Repository repository;

	public static Repository giveMemoryRepository() {
		
		if(repository == null){
			repository = new MemoryRepository();
		}		
		return repository;
	}

	public static DiseaseDTO giveDiseaseDTO() {
		return new DiseaseDTO("0", "diseaseDTO");
	}

	public static Disease giveDisease() {
		return new Disease("0", "disease");
	}

	public static SymptomDTO giveSymptomDTO() {
		return new SymptomDTO("0", "symptomDTO");
	}
	
	public static Symptom giveSymptom() {
		return new Symptom("0", "symptom");
	}

}
