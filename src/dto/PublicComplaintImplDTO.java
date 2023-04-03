package dto;

import java.time.LocalDate;

public class PublicComplaintImplDTO implements PublicComplaintDTO {

	private String email;
	private String crime_desc;
	private LocalDate crime_date;
	private LocalDate complaint_date;
	private String victim_name;
	private String suspect;
	private int crime_type;

	public PublicComplaintImplDTO(String email, String crime_desc, LocalDate crime_date, LocalDate complaint_date,
			String victim_name, String suspect, int crime_type) {
		super();
		this.email = email;
		this.crime_desc = crime_desc;
		this.crime_date = crime_date;
		this.complaint_date = complaint_date;
		this.victim_name = victim_name;
		this.suspect = suspect;
		this.crime_type = crime_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCrime_type() {
		return crime_type;
	}

	public void setCrime_type(int crime_type) {
		this.crime_type = crime_type;
	}

	public String getCrime_desc() {
		return crime_desc;
	}

	public void setCrime_desc(String crime_desc) {
		this.crime_desc = crime_desc;
	}

	public LocalDate getCrime_date() {
		return crime_date;
	}

	public void setCrime_date(LocalDate crime_date) {
		this.crime_date = crime_date;
	}

	public LocalDate getComplaint_date() {
		return complaint_date;
	}

	public void setComplaint_date(LocalDate complaint_date) {
		this.complaint_date = complaint_date;
	}

	public String getVictim_name() {
		return victim_name;
	}

	public void setVictim_name(String victim_name) {
		this.victim_name = victim_name;
	}

	public String getSuspect() {
		return suspect;
	}

	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}

	@Override
	public String toString() {
		return "Email = " + email + "\n" + "Crime_type = " + crime_type + "\n" + "Crime_desc = " + crime_desc + "\n" + "Crime_date = "
				+ crime_date + "\n" + "Complaint_date = " + complaint_date + "\n" + "Victim_name = " + victim_name + "\n" + "Suspect = "
				+ suspect + "\n";
	}

}
