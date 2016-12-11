package domain;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

public class Disease {

	//private String id;
	private String name;
    private String dbName; //Notation is 'd_lowercasename' example: Ebola -> d_ebola
	//private List<Symptom> symptoms;
	private Map<String, Symptom> symptoms;//the key is the id (the name) of the symptom, and the value is the symptom

	public Disease(String name) {
		//this.id = id;
		this.name = name;
        this.dbName = "d_" + name.toLowerCase();
        //this.symptoms = new ArrayList<Symptom>();
		this.symptoms = new HashMap<String, Symptom>();
	}

	/*
	public String getId() {
		return this.id;
	}
	 */
	
	public String getName() {
		return this.name;
	}

    public String getDBNodeName() { return this.dbName; }
	/*
	public List<Symptom> getSymptoms() {
		return symptoms;
	}
	*/
	
	public Map<String, Symptom> getSymptoms() {
		return this.symptoms;
	}

	public void addSymptom(Symptom symptom) {
		String symptomId = symptom.getName();
		this.symptoms.put(symptomId, symptom);
	}
}
