package domain;

import java.util.ArrayList;
import java.util.List;

public class Symptom {

	private String name;
	private String id;
	private List<Disease> diseases;

	public Symptom(String id, String name) {
		this.id = id;
		this.name = name;
		this.diseases = new ArrayList<Disease>();
	}

	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}

	public void addDisease(Disease disease) {
		this.diseases.add(disease);
		disease.addSymptom(this);
	}

	public List<Disease> getSicks() {
		return this.diseases;
	}
}
