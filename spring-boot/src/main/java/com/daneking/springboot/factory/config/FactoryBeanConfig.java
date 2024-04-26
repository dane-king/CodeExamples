package com.daneking.springboot.factory.config;

import com.daneking.springboot.factory.SingleToolFactory;
import com.daneking.springboot.factory.ToolFactory;
import com.daneking.springboot.factory.model.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FactoryBeanConfig {


    @Bean(name="tool")
    public ToolFactory toolFactory(){
        ToolFactory toolFactory = new ToolFactory();
        toolFactory.setFactoryId(7070);
        toolFactory.setToolId(2);
        return toolFactory;
    }

    @Bean(name="toolAbstract")
    public SingleToolFactory abstractToolFactory(){
        SingleToolFactory toolFactory = new SingleToolFactory();
        toolFactory.setFactoryId(9090);
        toolFactory.setToolId(5);
        return toolFactory;
    }


    @Bean()
    @Primary
    public Tool tool() throws Exception{
        return toolFactory().getObject();
    }
    @Bean("abstractTool")
    public Tool abstractTool(){
        return abstractToolFactory().createInstance();
    }

    @Bean("propertyTool")
    public Tool propertyTool(@Value("${tool.id:999}") int toolId){
        return new Tool(toolId);
    }
}
