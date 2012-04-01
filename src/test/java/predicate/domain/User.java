package predicate.domain;

public class User implements Comparable<User>{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authorized == null) ? 0 : authorized.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authorized == null) {
			if (other.authorized != null)
				return false;
		} else if (!authorized.equals(other.authorized))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	String name;
	Boolean authorized;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean isAuthorized() {
		return authorized;
	}
	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}
	public User(String name, Boolean authorized) {
		super();
		this.name = name;
		this.authorized = authorized;
	}
	public int compareTo(User user) {
		return this.getName().compareTo(user.getName());
	}

}
