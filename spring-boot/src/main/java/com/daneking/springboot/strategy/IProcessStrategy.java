package com.daneking.springboot.strategy;

//Don't annotate here, annotate subclasses with name
public interface IProcessStrategy {

	String process(final String type);

}