package com.daneking.springboot.factory;

import com.daneking.springboot.factory.config.FactoryBeanConfig;
import com.daneking.springboot.factory.model.Tool;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = FactoryBeanConfig.class)
class AbstractToolFactoryTest {
    @Autowired
    @Qualifier("abstractTool")
    private Tool tool;
    @Resource(name="&toolAbstract")
    private SingleToolFactory toolFactory;

    @Test
    void testConstructWorkerByJava() {
        assertEquals(tool.getToolId(), 5);
    }

}