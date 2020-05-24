package br.com.webcars.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.webcars.dtos.CarFilterDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long					id;

	@Column
	@NotEmpty
	private String					brand;

	@Column
	@NotEmpty
	private String					model;

	@Column
	@NotNull
	private Short					year;

	@Column(scale = 2, precision = 19)
	@NotNull
	private BigDecimal			price;

	public Car(CarFilterDTO dto)
	{
		id = dto.getId();
		brand = dto.getBrand();
		model = dto.getModel();
		year = dto.getYear();
		price = dto.getPrice();
	}

}
