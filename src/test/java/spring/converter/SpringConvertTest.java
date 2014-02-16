package spring.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:**/spring-converter.xml")
public class SpringConvertTest {
	@Autowired
	private ConversionServiceFactoryBean conversionServiceFactoryBean;

	@Test
	public void shouldBeAbleToCreateConversionService() {
		GenericConversionService conversionService = (GenericConversionService) conversionServiceFactoryBean
				.getObject();
		assertNotNull(conversionService);

	}

	@Test
	public void shouldBeAbleToConvertSourceToTarget() {
		GenericConversionService conversionService = (GenericConversionService) conversionServiceFactoryBean
				.getObject();
		Boolean canConvert = conversionService.canConvert(Source.class, Target.class);
		assertTrue(canConvert);

	}

	@Test
	public void shouldTransformTargetFromSource() {
		GenericConversionService conversionService = (GenericConversionService) conversionServiceFactoryBean
				.getObject();
		Source source = new Source();
		source.setBirthDate(new Date());
		Target target = conversionService.convert(source, Target.class);
		assertNotNull(target);

	}

}
