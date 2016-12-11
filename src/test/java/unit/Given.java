package unit;

import domain.Disease;
import domain.Symptom;
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

	public static Disease giveDisease() {
		return new Disease("diseaseDTO");
	}

	public static Symptom giveSymptom() {
		return new Symptom("symptom");
	}

}
