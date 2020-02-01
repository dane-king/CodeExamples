package com.daneking.springboot.strategy;

public interface ProcessStrategyFactory {
	IProcessStrategy getProcessor(String strategyName);

}
