package br.com.webcars.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.webcars.utils.Utils;

public class UtilsTest
{

	@Test
	@DisplayName("Formata para Moeda")
	void formatToCurrency()
	{
		String currency = Utils.formatToCurrency(BigDecimal.TEN);

		assertThat(currency).isEqualTo("R$ 10,00");
	}

	@Test
	@DisplayName("Formata para String")
	void formatToString()
	{

		String number = Utils.formatToString(BigDecimal.TEN);

		assertThat(number).isEqualTo("10");

		number = Utils.formatToString(BigDecimal.valueOf(10.20));

		assertThat(number).isEqualTo("10,2");

		number = Utils.formatToString(BigDecimal.valueOf(10.25));

		assertThat(number).isEqualTo("10,25");
	}

}
