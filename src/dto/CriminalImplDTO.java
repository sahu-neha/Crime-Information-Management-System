package dto;

import java.time.LocalDate;

public class CriminalImplDTO implements CriminalDTO {

	private String criminal_id;
	private String first_name;
	private String last_name;
	private LocalDate dob;
	private String gender;
	private String identifying_mark;
	private LocalDate first_arrest_date;
	private String arrested_from_ps_area;

	public CriminalImplDTO(String criminal_id, String first_name, String last_name, LocalDate dob, String gender,
			String identifying_mark, LocalDate first_arrest_date, String arrested_from_ps_area) {
		super();
		this.criminal_id = criminal_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.identifying_mark = identifying_mark;
		this.first_arrest_date = first_arrest_date;
		this.arrested_from_ps_area = arrested_from_ps_area;
	}

	public String getCriminal_id() {
		return criminal_id;
	}

	public void setCriminal_id(String criminal_id) {
		this.criminal_id = criminal_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentifying_mark() {
		return identifying_mark;
	}

	public void setIdentifying_mark(String identifying_mark) {
		this.identifying_mark = identifying_mark;
	}

	public LocalDate getFirst_arrest_date() {
		return first_arrest_date;
	}

	public void setFirst_arrest_date(LocalDate first_arrest_date) {
		this.first_arrest_date = first_arrest_date;
	}

	public String getArrested_from_ps_area() {
		return arrested_from_ps_area;
	}

	public void setArrested_from_ps_area(String arrested_from_ps_area) {
		this.arrested_from_ps_area = arrested_from_ps_area;
	}

	@Override
	public String toString() {
		return "Criminal ID = " + criminal_id + "\n" + "  |  First Name = " + first_name + "\n" + "  |  Last Name = " + last_name + "\n"
				+ "  |  Date of Birth = " + dob + "\n" + ", Gender = " + gender + "\n" + "  |  Identifying Mark = " + identifying_mark + "\n"
				+ "  |  First Arrest Date = " + first_arrest_date + "\n" + "  |  Arrested From Police Station Area = "
				+ arrested_from_ps_area + "\n";
	}

}
