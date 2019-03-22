package spring.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:**/spring-bean.xml")
public class ConcreteBeanTest {
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private IBean autoBean;

	@Test
	public void shouldCreateSpringBeanUsingContext() {
		IBean concreteBean = applicationContext.getBean(ConcreteBean.class);
		assertNotNull(concreteBean);
		assertEquals("default", concreteBean.getIt());
	}

	@Test
	public void shouldCreateSpringBeanWithAutowire() {
		assertNotNull(autoBean);
		assertEquals("default", autoBean.getIt());
	}
}
