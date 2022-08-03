package br.com.walter.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.walter.data.vo.v1.PersonVO;
import br.com.walter.service.PersonService;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable(value = "id") Long id){	
		return service.findById(id);
	}
	
	@GetMapping
	public List<PersonVO> findAll(){		
		return service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody PersonVO person){	
		service.create(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO person){	
		return service.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){	
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
