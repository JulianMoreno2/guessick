package service;

import domain.Sick;
import repository.SickRepository;

public class SickService {

	SickRepository sickRepository;
	
	public SickService(SickRepository sickRepository) {
		this.sickRepository = sickRepository;
	}

	public void saveSick(Sick sick) {
		//TODO: Something
		this.sickRepository.saveSick(sick);		
	}

}
