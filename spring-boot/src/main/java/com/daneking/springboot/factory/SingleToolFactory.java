package com.daneking.springboot.factory;

import com.daneking.springboot.factory.model.Tool;
import lombok.Data;
import org.springframework.beans.factory.config.AbstractFactoryBean;

@Data
public class SingleToolFactory extends AbstractFactoryBean<Tool> {
    private int toolId;
    private int factoryId;

    //makes it non singleton
//    public SingleToolFactory() {
//        setSingleton(false);
//    }

    @Override
    public Class<?> getObjectType() {
        return Tool.class;
    }

    @Override
    public Tool createInstance() {
        return new Tool(toolId);
    }

}
