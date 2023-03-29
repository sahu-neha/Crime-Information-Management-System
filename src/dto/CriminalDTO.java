package dto;

import java.time.LocalDate;

public interface CriminalDTO {

	public String getCriminal_id();

	public void setCriminal_id(String criminal_id);

	public String getFirst_name();

	public void setFirst_name(String first_name);

	public String getLast_name();

	public void setLast_name(String last_name);

	public LocalDate getDob();

	public void setDob(LocalDate dob);

	public String getGender();

	public void setGender(String gender);

	public String getIdentifying_mark();

	public void setIdentifying_mark(String identifying_mark);

	public LocalDate getFirst_arrest_date();

	public void setFirst_arrest_date(LocalDate first_arrest_date);

	public String getArrested_from_ps_area();

	public void setArrested_from_ps_area(String arrested_from_ps_area);

}
