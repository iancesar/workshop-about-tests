package br.com.webcars.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.webcars.entities.Car;
import br.com.webcars.factories.ModelMapperFactory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponseDTO implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	private Long					id;

	private String					brand;

	private String					model;

	private Short					year;

	private BigDecimal			price;

	private OwnerResponseDTO	owner;

	public static CarResponseDTO from(Car car)
	{
		CarResponseDTO dto = new CarResponseDTO();

		ModelMapper m = new ModelMapperFactory().getMapper();
		dto = m.map(car, CarResponseDTO.class);

		return dto;
	}

	public static List<CarResponseDTO> from(List<Car> cars)
	{
		var list = new ArrayList<CarResponseDTO>(cars.size());

		cars.forEach(car -> list.add(CarResponseDTO.from(car)));

		return list;
	}

}
