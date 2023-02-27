package com.daneking.springboot;

import com.daneking.springboot.beans.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("dev")
class ApplicationTests {
    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        Person person2= (Person) context.getBean("person2");
        com.daneking.external.beans.Person person1= (com.daneking.external.beans.Person) context.getBean("person1");
        Person personByType =context.getBean(Person.class);
        assertEquals("internal", person2.getName());
        assertEquals("internal", personByType.getName());
        assertEquals("override", person1.getName());
    }

}

