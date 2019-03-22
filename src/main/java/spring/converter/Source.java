package spring.converter;

import java.time.LocalDate;

public class Source {
	private String fname;
	private String lname;
	private LocalDate birthDate;

	public String getFname() {
		return fname;
	}

	public void setFname(final String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(final String lname) {
		this.lname = lname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
	}


}
