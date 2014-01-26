package dozer.immutable;

import org.dozer.DozerConverter;
import org.dozer.Mapper;

public class TestCustomConverter extends DozerConverter<Source, ImmutableDestination> {

	private final Mapper mapper;

	public TestCustomConverter(final Mapper mapper) {
		super(Source.class, ImmutableDestination.class);
		this.mapper = mapper;
	}

	@Override
	public ImmutableDestination convertTo(final Source source, final ImmutableDestination destination) {
		return new ImmutableDestination(source.getOne(), source.getTwo());
	}

	@Override
	public Source convertFrom(final ImmutableDestination destination, final Source source) {
		return mapper.map(destination, Source.class);

	}

}
