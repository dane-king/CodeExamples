package lambdas;

import java.util.ArrayList;
import java.util.List;

public class MethodReferences {
    public void usage(){
        List<String> list = new ArrayList<>();
        initialize(list, String::new);
    }

    @FunctionalInterface
    private interface Factory<T> {
        T create();
    }
    private <T> void initialize(List<T> list, Factory<T> function) {
        for (int i = 0; i < 10; i++) {
            list.add(function.create());
        }
    }

    public void usagePerson(){
        PersonFactory factory=Person::new;
        List<Person> list=new ArrayList<>();
        initializePerson(list,Person::new, "Joe King", 21);
    }


    @FunctionalInterface
    private interface PersonFactory{
        Person create(String name, Integer age);
    }
    private void initializePerson(List<Person> list, PersonFactory function, String name, Integer age) {
        for (int i = 0; i < 10; i++) {
            list.add(function.create(name, age));
        }
    }


    private class Person{
        private final Integer age;
        private String name;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }


    }
}
