package br.com.webcars.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import br.com.webcars.entities.Car;
import br.com.webcars.utils.Utils;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarFilterDTO implements Serializable
{

	private static final long	serialVersionUID	= 1L;

	private Long					id;

	private String					brand;

	private String					model;

	private Short					year;

	private BigDecimal			price;

	public Car to()
	{
		return new Car(this);
	}

	public static CarFilterDTO from(Map<String, String> map)
	{

		CarFilterDTOBuilder builder = CarFilterDTO.builder();

		Optional.ofNullable(map.get("year")).ifPresent(year -> builder.year(Short.valueOf(year)));
		Optional.ofNullable(map.get("id")).ifPresent(id -> builder.id(Long.valueOf(id)));
		Optional.ofNullable(map.get("price")).ifPresent(price -> builder.price(BigDecimal.valueOf(Utils.formatFromString(price))));

		return builder//
			.brand(map.get("brand"))//
			.model(map.get("model"))//
			.build();

	}

}
