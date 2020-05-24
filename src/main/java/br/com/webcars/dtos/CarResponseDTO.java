package br.com.webcars.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.webcars.entities.Car;
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

	public static CarResponseDTO from(Car car)
	{
		CarResponseDTO dto = new CarResponseDTO();

		BeanUtils.copyProperties(car, dto);
		return dto;
	}

	public static List<CarResponseDTO> from(List<Car> cars)
	{
		var list = new ArrayList<CarResponseDTO>(cars.size());

		cars.forEach(car -> list.add(CarResponseDTO.from(car)));

		return list;
	}

}
