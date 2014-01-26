package spring.strategy;

import org.springframework.stereotype.Component;

@Component("Type2")
public class Type2 implements IProcessStrategy {

	public String process(final String type) {
		System.out.println("In Type2 code");
		return "Type2" + type;
	}

}
