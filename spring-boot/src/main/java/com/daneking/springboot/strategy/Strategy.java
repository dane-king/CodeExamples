package com.daneking.springboot.strategy;



public class Strategy {
	private String state;
	private IProcessStrategy type;

	public IProcessStrategy getType() {
		return type;
	}

	public void setType(final IProcessStrategy type) {
		this.type = type;
	}

	public void invoke(final String typeArgument) {
		if ("a".equals(typeArgument)) {
			type = new Type1();
			state = type.process(typeArgument);
		} else if ("b".equals(typeArgument)) {
			type = new Type2();
			state = type.process(typeArgument);
		} else if ("c".equals(typeArgument)) {
			type = new Type3();
			state = type.process(typeArgument);
		}
	}

	public String getState() {
		return state;
	}

	public String processType3(final String type) {
		System.out.println("In Type3 code");
		return "Type3" + type;
	}

}
