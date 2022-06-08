
package br.com.walter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.walter.model.Person;
import br.com.walter.model.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repo;
	
	public Person findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No rocord found for this ID"));
	}
	
	public List<Person> findAll() {
		return repo.findAll();
	}
	
	public Person create(Person person) {
		return repo.save(person);
	}
	
	public Person update(Person oldPerson) {
		
		Person newPerson  =repo.findById(oldPerson.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No rocord found for this ID"));
		
		newPerson.setFirstName(oldPerson.getFirstName());
		newPerson.setLastName(oldPerson.getLastName());
		newPerson.setAdress(oldPerson.getAdress());
		newPerson.setGender(oldPerson.getGender());
		
		return repo.save(newPerson);
	}
	
	public void delete(Long id) {
		Person person = findById(id);
		repo.delete(person);
	}

}


