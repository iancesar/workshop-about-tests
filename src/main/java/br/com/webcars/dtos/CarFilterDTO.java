package br.com.webcars.dtos;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import br.com.webcars.entities.Car;
import br.com.webcars.utils.Utils;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarFilterDTO
{

	private Long			id;

	private String			brand;

	private String			model;

	private Short			year;

	private BigDecimal	price;

	public Car to()
	{
		return new Car(this);
	}

	public static CarFilterDTO from(Map<String, String> map)
	{

		var year = new Supplier<Short>()
		{

			@Override
			public Short get()
			{
				if(Optional.ofNullable(map.get("year")).isPresent())
				{
					return Short.valueOf(map.get("year"));
				}
				else
				{
					return null;
				}
			}
		};

		var id = new Supplier<Long>()
		{
			@Override
			public Long get()
			{
				if(Optional.ofNullable(map.get("id")).isPresent())
				{
					return Long.valueOf(map.get("id"));
				}
				else
				{
					return null;
				}
			}
		};

		var price = new Supplier<BigDecimal>()
		{
			@Override
			public BigDecimal get()
			{
				if(Optional.ofNullable(map.get("price")).isPresent())
				{
					return BigDecimal.valueOf(Utils.formatFromString(map.get("price")));
				}
				else
				{
					return null;
				}
			}
		};

		var filter = CarFilterDTO.builder()//
			.brand(map.get("brand"))//
			.model(map.get("model"))//
			.year(year.get())//
			.price(price.get())//
			.id(id.get())//
			.build();

		return filter;
	}

}
