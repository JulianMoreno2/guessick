package resources;

import adapter.SickAdapter;
import domain.Sick;
import domain.Symptom;
import dto.SickDTO;

public class SickResource {
	
	private SickAdapter sickAdapter;

	public SickResource(SickAdapter symptomAdapter) {
		this.sickAdapter = symptomAdapter;
	}

	public Sick saveSyptom(SickDTO sickDTO) {		
		Sick sick = this.sickAdapter.saveSick(sickDTO);
		return sick;
	}
}
