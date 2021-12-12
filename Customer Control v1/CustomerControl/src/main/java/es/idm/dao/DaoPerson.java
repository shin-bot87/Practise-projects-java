package es.idm.dao;

import es.idm.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoPerson extends JpaRepository<Person, Long> {
    
}
