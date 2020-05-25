package br.com.webcars.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import br.com.webcars.dtos.CarFilterDTO;
import br.com.webcars.dtos.CarResponseDTO;
import br.com.webcars.entities.Car;
import br.com.webcars.entities.Owner;
import br.com.webcars.utils.Utils;

class CarTest
{

	@Test
	@DisplayName("Converter Car para CarResponseDTO")
	void toResponse() throws Exception
	{

		Owner owner = new Owner(1L, "Ian", "ian@teste.com.br", "(31) 98638-3745", null);

		final Car car = new Car(1L, "Fiat", "Uno", (short) 2009, BigDecimal.valueOf(12000), owner);

		CarResponseDTO responseDTO = CarResponseDTO.from(car);

		assertThat(responseDTO).usingRecursiveComparison().isEqualTo(car);

	}

	@Test
	@DisplayName("Converter Lista de Car para Lista de CarResponseDTO")
	void toResponseList() throws Exception
	{
		Owner owner = new Owner(1L, "Ian", "ian@teste.com.br", "(31) 98638-3745", null);

		final List<Car> cars = Stream.of(//
			new Car(1L, "Fiat", "Uno", (short) 2009, BigDecimal.valueOf(12000), owner), //
			new Car(2L, "Fiat", "Palio", (short) 2011, BigDecimal.valueOf(26000), owner))//
			.collect(Collectors.toList());

		List<CarResponseDTO> responseListDTO = CarResponseDTO.from(cars);

		assertThat(responseListDTO).isNotEmpty();

		responseListDTO.forEach(dto -> {
			Car currentCar = cars.stream().filter(car -> car.getId().equals(dto.getId())).findAny().get();
			assertThat(dto).usingRecursiveComparison().isEqualTo(currentCar);
		});

	}

	@Test
	@DisplayName("Converte um CarFilterDTO para Car")
	void toCar() throws Exception
	{
		CarFilterDTO dto = CarFilterDTO.builder()//
			.brand("Fiat")//
			.model("Uno")//
			.price(BigDecimal.valueOf(12000))//
			.year((short) 2009)//
			.build();

		Car car = dto.to();

		assertThat(dto).isEqualToComparingFieldByField(car);
	}

	@Test
	@DisplayName("Criar um CarFilterDTO a partir de um map")
	void fromMap() throws Exception
	{
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("brand", "Fiat");
		params.add("model", "Uno");
		params.add("price", Utils.formatToString(BigDecimal.TEN));
		params.add("year", "2009");
		params.add("id", "1");

		CarFilterDTO filter = CarFilterDTO.from(params.toSingleValueMap());

		assertThat(filter).hasNoNullFieldsOrProperties();

	}

}
