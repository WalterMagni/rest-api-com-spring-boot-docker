package br.com.walter.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.walter.model.Person;
import br.com.walter.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable(value = "id") Long id){	
		return service.findById(id);
	}
	
	@GetMapping
	public List<Person> findAll(){		
		return service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Person person){	
		service.create(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Person update(@RequestBody Person person){	
		return service.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){	
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
