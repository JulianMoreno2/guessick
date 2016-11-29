package dto;

public class DiseaseDTO {
	
	private String id;
	private String name;

	public DiseaseDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

}
