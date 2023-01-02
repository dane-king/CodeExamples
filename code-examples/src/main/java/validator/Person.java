package validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Age cannot be null")
    private Integer age;

    List<@NotBlank String> items;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(String item) {
        if(items==null){
            items=new ArrayList();
        }
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", items=" + items.stream().toString() +
                '}';
    }
}
