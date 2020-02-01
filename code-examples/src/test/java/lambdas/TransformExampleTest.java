package lambdas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Function;

import static lambdas.TransformExample.Person;
import static lambdas.TransformExample.PersonResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class TransformExampleTest {
    Function<PersonResponse, Person> transformResponseToPerson = (p) -> new Person(getFullName(p), p.getPersonAge());

    private String getFullName(PersonResponse p) {
        return p.getFirstName() + " " + p.getLastName();
    }

    Transform<PersonResponse, Person> transformPersonToResponse = source -> {
        PersonResponse response=new PersonResponse();
        response.setPersonAge(source.getAge());
        String[] nameParts=source.getName().split(" ");
        if(nameParts.length==2){
            response.setFirstName(nameParts[0]);
            response.setLastName(nameParts[1]);
        }

        return response;
    };


    @Test
    public void shouldBeAbleToMapResponseToObject() {

        assertThat(buildResponse().toPerson(transformResponseToPerson), equalTo(buildPerson()));

    }

    @Test
    public void shouldBeAbleToMapObjectToResponse() {

        assertThat(buildPerson().toPersonResponse(transformPersonToResponse), equalTo(buildResponse()));

    }

    private Person buildPerson() {
        return new Person("Joe King", 21);
    }

    private PersonResponse buildResponse() {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setFirstName("Joe");
        personResponse.setLastName("King");
        personResponse.setPersonAge(21);
        return personResponse;
    }
}
