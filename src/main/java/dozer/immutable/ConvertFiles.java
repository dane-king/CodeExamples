package dozer.immutable;

import org.dozer.DozerBeanMapper;

public class ConvertFiles {

	public Destination convert(final Source source) {
		/*
		 * CustomConverter converter = new CustomConverter(Source.class,
		 * Target.class); Target target = converter.convertTo(source);
		 */

		DozerBeanMapper mapper = new DozerBeanMapper();
		return mapper.map(source, Destination.class, "");
	}
}
