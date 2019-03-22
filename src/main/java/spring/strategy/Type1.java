package spring.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class Type1 implements IProcessStrategy {

	public String process(final String type) {
		System.out.println("In Type1 code");
		return "Type1" + type;
	}

}
