package spring.strategy;

//Don't annotate here, annotate subclasses with name
public interface IProcessStrategy {

	String process(final String type);

}