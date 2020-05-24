package br.com.webcars;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.webcars.factories.ModelMapperFactory;

@SpringBootApplication
public class WebCarsApplication
{

	public static void main(final String[] args)
	{
		SpringApplication.run(WebCarsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapperFactory().factory();
	}
}
