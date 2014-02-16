package spring.converter;

import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.core.convert.converter.Converter;

public class SourceToTargetConverter implements Converter<Source, Target> {

	public Target convert(final Source source) {
		Target target = new Target();
		target.setName(source.getFname() + " " + source.getLname());
		target.setAge(calculateAge(source));
		return target;
	}

	private int calculateAge(final Source source) {
		LocalDate birthdate = LocalDate.fromDateFields(source.getBirthDate());
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(birthdate, now);
		return age.getYears();
	}

}
