package br.com.walter.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.walter.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
