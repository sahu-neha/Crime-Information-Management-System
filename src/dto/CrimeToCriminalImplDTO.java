package dto;

public class CrimeToCriminalImplDTO implements CrimeToCriminalDTO {

	private String crime_id;
	private String criminal_id;

	public CrimeToCriminalImplDTO(String crime_id, String criminal_id) {
		super();
		this.crime_id = crime_id;
		this.criminal_id = criminal_id;
	}

	public String getCrime_id() {
		return crime_id;
	}

	public void setCrime_id(String crime_id) {
		this.crime_id = crime_id;
	}

	public String getCriminal_id() {
		return criminal_id;
	}

	public void setCriminal_id(String criminal_id) {
		this.criminal_id = criminal_id;
	}

	@Override
	public String toString() {
		return "Crime ID = " + crime_id + ", Criminal ID = " + criminal_id;
	}

}
