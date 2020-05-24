package br.com.webcars.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import br.com.webcars.exceptions.BusinessException;

public class Utils
{

	private static final Locale			BRAZILIAN_LOCALE	= new Locale("pt", "BR");

	private static final NumberFormat	CURRENCY_INSTANCE	= NumberFormat.getCurrencyInstance(BRAZILIAN_LOCALE);

	private static final NumberFormat	NUMBER_FORMAT		= NumberFormat.getNumberInstance(BRAZILIAN_LOCALE);

	private Utils()
	{
	}

	public static String formatToCurrency(BigDecimal value)
	{
		return CURRENCY_INSTANCE.format(value);
	}

	public static String formatToString(BigDecimal value)
	{
		return NUMBER_FORMAT.format(value);
	}

	public static Long formatFromString(String value)
	{
		try
		{
			return NUMBER_FORMAT.parse(value).longValue();
		}
		catch(ParseException e)
		{
			throw new BusinessException("Erro ao realizar a conversão");
		}
	}

}
