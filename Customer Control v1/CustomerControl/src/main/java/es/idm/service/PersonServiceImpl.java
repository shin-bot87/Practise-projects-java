package es.idm.service;

import es.idm.dao.DaoPerson;
import es.idm.domain.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    private DaoPerson daoPerson;

    @Override
    @Transactional(readOnly = true)
    public List<Person> listPerson() {
        return (List<Person>) daoPerson.findAll();
    }

    @Override
    @Transactional
    public void save(Person person) {
        daoPerson.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        daoPerson.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person person) {
        return daoPerson.findById(person.getIdPerson()).orElse(null);
    }
    
    
}
