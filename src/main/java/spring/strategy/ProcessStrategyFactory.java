package spring.strategy;

public interface ProcessStrategyFactory {
	IProcessStrategy getProcessor(String strategyName);

}
