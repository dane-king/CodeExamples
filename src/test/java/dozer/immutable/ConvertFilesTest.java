package dozer.immutable;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

/**
 * Manual loading of the mapping file
 * 
 * 
 */
public class ConvertFilesTest {
	private DozerBeanMapper mapper;
	private Source source;

	@Before
	public void setup() {
		mapper = new DozerBeanMapper();
		source = stubSource();
		List<String> myMappingFiles = new ArrayList<String>();
		myMappingFiles.add("dozer/immutable/dozerMapping.xml");
		myMappingFiles.add("dozer/immutable/dozerConfiguration.xml");
		mapper.setMappingFiles(myMappingFiles);
		List<CustomConverter> customConverters = new ArrayList<CustomConverter>();
		customConverters.add(new TestCustomConverter(mapper));
		mapper.setCustomConverters(customConverters);
	}

	@Test
	public void convertSourceToTargetStandardMapping() throws Exception {
		Destination destination = mapper.map(source, Destination.class);
		assertEquals("one", destination.getOnePrime());
		assertEquals("two", destination.getTwo());
	}

	@Test
	public void convertSourceToTargetUsingConverter() throws Exception {
		ImmutableDestination destination = mapper.map(source, ImmutableDestination.class);
		assertEquals("one", destination.getOne());
		assertEquals("two", destination.getTwo());
	}

	private Source stubSource() {
		Source source = new Source();
		source.setOne("one");
		source.setTwo("two");
		return source;
	}

}
