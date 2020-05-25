package br.com.webcars.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Owner implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long					id;

	@Column
	@NotBlank
	private String					name;

	@Column
	@NotBlank
	@Email
	private String					email;

	@Column(length = 15)
	@Size(min = 15, max = 15)
	@NotBlank
	private String					phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Car>				cars;

}
