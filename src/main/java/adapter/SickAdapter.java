package adapter;

import domain.Sick;
import dto.SickDTO;
import service.SickService;

public class SickAdapter {
	
	SickService sickService;
	
	public SickAdapter(SickService sickService) {
		this.sickService = sickService;
	}

	public Sick saveSick(SickDTO sickDTO){
		
		String id = sickDTO.getId();
		String name = sickDTO.getName();
		Sick sick = new Sick(id, name);
		
		this.sickService.saveSick(sick);
		
		return sick;
	}
}
