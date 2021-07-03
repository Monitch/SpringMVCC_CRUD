package SpringTest.dao;

import SpringTest.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;
    PersonDAO()
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Vitaliy", 21, "Vitaliy@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Denis", 24, "boban@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Nikolay", 22, "NikLy@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Vasyl", 27, "vasya@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        for (Person person : people) {
            if (person.getId() == id)
                return person;
        }
        return null;
    }
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id,Person updatedPerson) {
        Person personToUpdated = show(id);

        personToUpdated.setName(updatedPerson.getName());
        personToUpdated.setAge(updatedPerson.getAge());
        personToUpdated.setEmail(updatedPerson.getEmail());
    }
    public void delete(int id){
        int index=0;
        for (Person person : people) {
            if (person.getId() == id){
                break;
            }
            index++;
        }

        people.remove(index);
    }
}
