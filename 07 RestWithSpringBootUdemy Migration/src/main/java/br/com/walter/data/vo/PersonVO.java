package br.com.walter.data.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	private Long id;

	private String firstName;
	private String lastName;
	private String address;
	private String gender;

}
