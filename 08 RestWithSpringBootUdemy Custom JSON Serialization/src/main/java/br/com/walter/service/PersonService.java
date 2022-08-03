
package br.com.walter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.walter.converter.DozerConverter;
import br.com.walter.data.model.Person;
import br.com.walter.data.vo.v1.PersonVO;
import br.com.walter.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repo;
	
	public PersonVO findById(Long id) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No rocord found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll() {		
		return DozerConverter.parseListObjects(repo.findAll(), PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repo.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		var entity  = repo.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No rocord found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return DozerConverter.parseObject(repo.save(entity), PersonVO.class);
	}
	
	public void delete(Long id) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No rocord found for this ID"));
		repo.delete(entity);
	}

}


