package br.com.webcars.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import br.com.webcars.entities.Car;
import br.com.webcars.repositories.car.CarRepository;

class CarRepositoryIT extends BaseIT
{

	@Autowired
	private CarRepository repository;

	@Test
	@DisplayName("Buscar todos join Owner por exemplo,")
	void findAllJoinOwner()
	{

		Car car = new Car(null, "Fiat", "Uno", (short) 2009, BigDecimal.valueOf(12000), null);

		List<Car> cars = repository.findAllJoinOwner(Example.of(car));

		assertThat(cars).isNotEmpty();

		assertThat(cars.get(0)).hasNoNullFieldsOrProperties();

	}

}
