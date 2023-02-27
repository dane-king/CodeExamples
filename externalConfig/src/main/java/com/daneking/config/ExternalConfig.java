package com.daneking.config;

import com.daneking.external.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class ExternalConfig {
    //method name is bean name
    public Person externalPerson(String name){
        Person person = new Person();
        person.setName(name);
        return person;
    }

}
