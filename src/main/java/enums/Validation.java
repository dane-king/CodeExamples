package enums;

import java.util.regex.Pattern;


public enum Validation{
	Email() {
		@Override
		public boolean validate(String value) {
			return EMAIL_PATTERN.matcher(value).matches();
		}
	},
	Name() {
		@Override
		public boolean validate(String value) {
			return NAME_PATTERN.matcher(value).matches();
		}
	};
	
	// not complete regex patterns for validation just an example
	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static final Pattern NAME_PATTERN = Pattern
			.compile("^[A-Z][-'a-zA-Z]+$");

	
	public abstract boolean validate(String value);
}
