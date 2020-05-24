package br.com.shoppingcart.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.webcars.utils.Utils;

public class UtilsTest {

	@Test
	public void formatToCurrency() {
		String currency = Utils.formatToCurrency(BigDecimal.TEN);

		assertEquals("R$ 10,00", currency);
	}

}
