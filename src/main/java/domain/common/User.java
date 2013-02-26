package domain.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class User implements Comparable<User> {
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name).append(this.isAuthorized()).hashCode();

	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof User == false) {
			return false;
		}

		if (this == obj) {
			return true;
		}
		User other = (User) obj;
		return new EqualsBuilder().append(this.name, other.name).append(this.isAuthorized(), other.isAuthorized())
				.isEquals();
	}

	private String name;
	private Boolean authorized;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(final Boolean authorized) {
		this.authorized = authorized;
	}

	public User(final String name, final Boolean authorized) {
		super();
		this.name = name;
		this.authorized = authorized;
	}

	public int compareTo(final User user) {
		return this.getName().compareTo(user.getName());
	}

}
