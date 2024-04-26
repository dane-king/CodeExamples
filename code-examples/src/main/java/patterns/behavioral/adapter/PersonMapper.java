package patterns.behavioral.adapter;


public class PersonMapper {
    private final GenericMapper<PersonDTO, Person> personMapper;

    public PersonMapper() {
        personMapper = new GenericMapper<>(
                person -> new PersonDTO(person.getName().getFirstName(), person.getName().getLastName(), person.getAge()),
                dto -> new Person(new Name(dto.getFirstName(), dto.getLastName()), dto.getAge()));
    }

    public PersonDTO toDto(Person person) {
        return personMapper.toDto(person);
    }

    public Person toEntity(PersonDTO dto) {
        return personMapper.toEntity(dto);
    }
}