package es.idm.service;

import es.idm.domain.Person;
import java.util.List;

public interface PersonService {
    
    public List<Person> listPerson();
    
    public void save(Person person);
    
    public void delete(Person person);
    
    public Person findPerson(Person person);
}
