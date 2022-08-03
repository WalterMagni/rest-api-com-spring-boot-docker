package br.com.walter.data.vo.v1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonPropertyOrder({"id", "address", "firstName", "lastName", "gender"})
public class PersonVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	private Long id;

	@JsonProperty("Primeiro Nome")
	private String firstName;
	@JsonProperty("Ultimo Nome")
	private String lastName;
	@JsonProperty("Endereço")
	private String address;
	@JsonIgnore
	private String gender;

}
