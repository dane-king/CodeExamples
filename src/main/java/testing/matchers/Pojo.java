package testing.matchers;

public class Pojo {
	private String fname;
	private String lname;

	public Pojo(final String fname, final String lname) {
		this.fname = fname;
		this.lname = lname;
	}

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

}
