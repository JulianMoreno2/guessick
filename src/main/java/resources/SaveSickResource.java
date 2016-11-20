package resources;

import adapter.SickAdapter;
import domain.Sick;
import dto.SickDTO;

public class SaveSickResource {
	
	private SickAdapter sickAdapter;

	public SaveSickResource(SickAdapter sickAdapter) {
		this.sickAdapter = sickAdapter;
	}

	public Sick saveSyptom(SickDTO sickDTO) {		
		Sick sick = this.sickAdapter.saveSick(sickDTO);
		return sick;
	}
}
