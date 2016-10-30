package dto;

public class SickDTO {
	
	private String id;
	private String name;

	public SickDTO(String id, String name) {
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
