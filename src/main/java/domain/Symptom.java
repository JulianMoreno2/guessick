package domain;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

public class Symptom {

	private String name;
    private String dbName; //Notation is 's_lowercasename' example: Fever -> s_fever
	//private String id;
	//private List<Disease> diseases;
	private Map<String, Disease> diseases; // the key is the name

	public Symptom(String name) {
		//this.id = id;
		this.name = name;
        this.dbName = "s_" + name.toLowerCase();
		this.diseases = new HashMap<String, Disease>();
	}

	public String getName() {
		return this.name;
	}

    public String getDBNodeName() { return this.dbName; }
	/*
	public String getId() {
		return this.id;
	}
	*/

	public void addDisease(Disease disease) {
		//this.diseases.add(disease);
		//disease.addSymptom(this);
		String diseaseName = disease.getName();
		this.diseases.put(diseaseName, disease);
		disease.addSymptom(this);
	}

	/*
	public List<Disease> getDiseases() {
		return this.diseases;
	}
	*/
	public Map<String, Disease> getDiseases() {
		return this.diseases;
	}
}
