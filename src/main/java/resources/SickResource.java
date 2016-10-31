package resources;

import adapter.SickAdapter;
import domain.Sick;
import dto.SickDTO;

public class SickResource {
	
	private SickAdapter sickAdapter;

	public SickResource(SickAdapter sickAdapter) {
		this.sickAdapter = sickAdapter;
	}

	public Sick saveSyptom(SickDTO sickDTO) {		
		Sick sick = this.sickAdapter.saveSick(sickDTO);
		return sick;
	}
}
