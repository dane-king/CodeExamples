package com.daneking.springboot.config;


import com.daneking.config.ExternalConfig;
import com.daneking.external.beans.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OverrideConfig  extends ExternalConfig {
    @Override
    @Bean("person1")
    public Person externalPerson(@Value("${person.name:}") String name) {
        return super.externalPerson(name);
    }
}
