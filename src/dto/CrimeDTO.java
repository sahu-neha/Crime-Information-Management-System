package dto;

import java.time.LocalDate;

public interface CrimeDTO {

	public String getCrime_id();

	public void setCrime_id(String crime_id);

	public int getCrime_type();

	public void setCrime_type(int crime_type);

	public String getCrime_desc();

	public void setCrime_desc(String crime_desc);

	public String getPs_area();

	public void setPs_area(String ps_area);

	public LocalDate getCrime_date();

	public void setCrime_date(LocalDate crime_date);

	public LocalDate getComplaint_date();

	public void setComplaint_date(LocalDate complaint_date);

	public String getVictim_name();

	public void setVictim_name(String victim_name);

}
