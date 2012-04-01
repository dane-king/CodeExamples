package drools.domain;

import java.util.Date;

public class Application {
	private Date dateApplied;
	private boolean isValid;
	
	@Override
	public String toString() {
		return "Application [dateApplied=" + dateApplied + ", isValid="
				+ isValid + "]";
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Application() {
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}
}