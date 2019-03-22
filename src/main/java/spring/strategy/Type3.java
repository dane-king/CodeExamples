package spring.strategy;

import org.springframework.stereotype.Component;

@Component("Type3")
public class Type3 implements IProcessStrategy {

	public String process(final String type) {
		System.out.println("In Type3 code");
		return "Type3" + type;
	}

}