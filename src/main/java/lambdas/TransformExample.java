package lambdas;

import java.util.Objects;
import java.util.function.Function;



public class TransformExample {

    public static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        public PersonResponse toPersonResponse(Transform<PersonResponse,Person> transformFn) {
            return transformFn.transform(this);
        }
    }


    public static class PersonResponse{
        private String firstName;
        private String lastName;
        private int personAge;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getPersonAge() {
            return personAge;
        }

        public void setPersonAge(int personAge) {
            this.personAge = personAge;
        }

        public Person toPerson(Function<PersonResponse,Person> transform) {
            return transform.apply(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PersonResponse)) return false;
            PersonResponse that = (PersonResponse) o;
            return personAge == that.personAge &&
                    Objects.equals(firstName, that.firstName) &&
                    Objects.equals(lastName, that.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, personAge);
        }

        @Override
        public String toString() {
            return "PersonResponse{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", personAge=" + personAge +
                    '}';
        }
    }
}
