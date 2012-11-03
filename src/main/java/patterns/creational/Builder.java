package patterns.creational;

public class Builder {

	private final String required1;
	private final String required2;
	private final String optional1;
	private final String optional2;
	private final String optional3;
	

	public String getRequired1() {
		return required1;
	}


	public String getRequired2() {
		return required2;
	}


	public String getOptional1() {
		return optional1;
	}


	public String getOptional2() {
		return optional2;
	}


	public String getOptional3() {
		return optional3;
	}


	public static class InternalBuilder{
		private final String required1;
		private final String required2;
		
		private String optional1="";
		private String optional2="";
		private String optional3="";
		
		public InternalBuilder(String required1, String required2) {
			this.required1 = required1;
			this.required2 = required2;
		}
		public InternalBuilder option1(String optional1){
			this.optional1=optional1;
			return this;
		}
		public InternalBuilder option2(String optional2){
			this.optional2=optional2;
			return this;
		}
		public InternalBuilder option3(String optional3){
			this.optional3=optional3;
			return this;
		}
		public Builder build(){
			return new Builder(this);
		}
	}
	public Builder(InternalBuilder internalBuilder){
		this.required1=internalBuilder.required1;
		this.required2=internalBuilder.required2;
		this.optional1=internalBuilder.optional1;
		this.optional2=internalBuilder.optional2;
		this.optional3=internalBuilder.optional3;
	}

}
