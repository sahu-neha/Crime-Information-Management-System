package dto;

import java.time.LocalDate;

public interface PublicComplaintDTO {

	public String getEmail();

	public void setEmail(String email);

	public int getCrime_type();

	public void setCrime_type(int crime_type);

	public String getCrime_desc();

	public void setCrime_desc(String crime_desc);

	public LocalDate getCrime_date();

	public void setCrime_date(LocalDate crime_date);

	public LocalDate getComplaint_date();

	public void setComplaint_date(LocalDate complaint_date);

	public String getVictim_name();

	public void setVictim_name(String victim_name);

	public String getSuspect();

	public void setSuspect(String suspect);

}
