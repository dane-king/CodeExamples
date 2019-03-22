package spring.converter;


import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.Period;

public class SourceToTargetConverter implements Converter<Source, Target> {

	public Target convert(final Source source) {
		Target target = new Target();
		target.setName(source.getFname() + " " + source.getLname());
		target.setAge(calculateAge(source));
		return target;
	}

	private int calculateAge(final Source source) {
		LocalDate birthdate = source.getBirthDate();
		LocalDate now = LocalDate.now();
		return Period.between(now,birthdate).getYears();
	}

}
