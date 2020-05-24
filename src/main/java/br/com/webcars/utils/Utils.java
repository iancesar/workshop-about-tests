package br.com.webcars.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

	private static final NumberFormat CURRENCY_INSTANCE = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

	private Utils() {
	}

	public static String formatToCurrency(BigDecimal value) {
		return CURRENCY_INSTANCE.format(value);
	}

}
