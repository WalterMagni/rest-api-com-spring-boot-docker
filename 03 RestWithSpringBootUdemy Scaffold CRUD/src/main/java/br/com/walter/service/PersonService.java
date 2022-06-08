
package br.com.walter.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.walter.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}

	public Person findById(String id) {
		Person person = new Person();

		person.setId(counter.incrementAndGet());
		person.setFirstName("Walter");
		person.setLastName("Magni");
		person.setAdress("Rua Padre Carlos da Silva, 108");
		person.setGender("Male");

		return person;
	}

	public List<Person> findAll() {

		Person person = new Person();

		person.setId(counter.incrementAndGet());
		person.setFirstName("Walter");
		person.setLastName("Magni");
		person.setAdress("Rua Padre Carlos da Silva, 108");
		person.setGender("Male");
		
		Person person2 = new Person();

		person2.setId(counter.incrementAndGet());
		person2.setFirstName("Juliane");
		person2.setLastName("Magni");
		person2.setAdress("Rua Padre Carlos da Silva, 108");
		person2.setGender("Female");
		
		return Arrays.asList(person, person2);

	}

}
