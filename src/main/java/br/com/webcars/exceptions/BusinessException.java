package br.com.webcars.exceptions;

/**
 * 
 * @author ian
 *
 */
public class BusinessException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public BusinessException(String msg)
	{
		super(msg);
	}

}
