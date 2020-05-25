package br.com.webcars.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.webcars.dtos.CarResponseDTO;
import br.com.webcars.entities.Car;
import br.com.webcars.entities.Owner;

class OwnerTest
{

	@Test
	@DisplayName("Converter Owner para OwnerResponseDTO")
	void toResponse() throws Exception
	{
		Owner owner = new Owner(1L, "Ian", "ian@teste.com.br", "(31) 98638-3745", null);

		final Car car = new Car(1L, "Fiat", "Uno", (short) 2009, BigDecimal.valueOf(12000), owner);

		CarResponseDTO responseDTO = CarResponseDTO.from(car);

		assertThat(responseDTO).usingRecursiveComparison().isEqualTo(car);

	}


}
