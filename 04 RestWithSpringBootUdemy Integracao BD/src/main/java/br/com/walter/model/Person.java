package br.com.walter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "person")
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 30)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 30)
	private String lastName;
	@Column(nullable = false, length = 50)
	private String adress;
	@Column(nullable = false, length = 10)
	private String gender;

}
