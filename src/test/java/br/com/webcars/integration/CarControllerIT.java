package br.com.webcars.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import br.com.webcars.dtos.CarFilterDTO;
import br.com.webcars.dtos.CarResponseDTO;
import br.com.webcars.utils.Utils;

class CarControllerIT extends BaseIT
{

	@Test
	@DisplayName("Listar carros")
	void list() throws Exception
	{

		CarFilterDTO filter = CarFilterDTO.builder()//
			.brand("Fiat")//
			.model("Uno")//
			.price(BigDecimal.valueOf(12000))//
			.year((short) 2009)//
			.build();

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("brand", filter.getBrand());
		params.add("model", filter.getModel());
		params.add("price", Utils.formatToString(filter.getPrice()));
		params.add("year", filter.getYear().toString());

		RequestBuilder requestBuilder = get("/cars/").params(params);

		MockHttpServletResponse response = mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();

		List<CarResponseDTO> cars = Arrays.asList(mapper.readValue(response.getContentAsString(), CarResponseDTO[].class));

		assertThat(cars).hasSize(1);

		assertThat(cars.get(0)).hasNoNullFieldsOrProperties();

	}

}
