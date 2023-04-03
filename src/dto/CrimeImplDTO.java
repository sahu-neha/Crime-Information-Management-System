package dto;

import java.time.LocalDate;

public class CrimeImplDTO implements CrimeDTO {

	private String crime_id;
	private int crime_type;
	private String crime_desc;
	private String ps_area;
	private LocalDate crime_date;
	private LocalDate complaint_date;
	private String victim_name;

	public CrimeImplDTO(String crime_id, int crime_type, String crime_desc, String ps_area, LocalDate crime_date,
			LocalDate complaint_date, String victim_name) {
		super();
		this.crime_id = crime_id;
		this.crime_type = crime_type;
		this.crime_desc = crime_desc;
		this.ps_area = ps_area;
		this.crime_date = crime_date;
		this.complaint_date = complaint_date;
		this.victim_name = victim_name;
	}

	public String getCrime_id() {
		return crime_id;
	}

	public void setCrime_id(String crime_id) {
		this.crime_id = crime_id;
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

	public String getPs_area() {
		return ps_area;
	}

	public void setPs_area(String ps_area) {
		this.ps_area = ps_area;
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

	@Override
	public String toString() {
		return "Crime ID = " + crime_id + "\n" + "  |  Crime Type = " + crime_type + "\n" + "  |  Crime Desc = " + crime_desc
				 + "\n"	+ "  |  Police Station Area = " + ps_area + "\n" + "  |  Crime Date = " + crime_date + "\n" + "  |  Complaint Date = "
				+ complaint_date + "\n" + "  |  Victim Date = " + victim_name + "\n";
	}

}
