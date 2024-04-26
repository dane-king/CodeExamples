package com.daneking.springboot.factory;

import com.daneking.springboot.factory.config.FactoryBeanConfig;
import com.daneking.springboot.factory.model.Tool;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = FactoryBeanConfig.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class ToolFactoryTest {
    @Autowired
    private Tool tool;
    @Autowired
    @Qualifier("propertyTool")
    private Tool propertyTool;

    @Resource(name="&tool")
    private ToolFactory toolFactory;

    @Test
    void testConstructToolWithFactory() {
        assertEquals(tool.getToolId(), 2);
    }

    @Test
    void testPropertyWiredBean() {
        assertEquals(propertyTool.getToolId(), 7);
    }

}