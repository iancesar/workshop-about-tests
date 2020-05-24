package br.com.webcars.utils;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{

	//	@ExceptionHandler(entu.class)
	//	public ResponseEntity<ErrorDTO> handleBusinessException(final BusinessException e)
	//	{
	//		final ErrorDTO error = new ErrorDTO.Builder().withThrowable(e).build();
	//
	//		return ResponseEntity.status(406).body(error);
	//	}

}
