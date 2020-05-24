package br.com.webcars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.webcars.dtos.CarFilterDTO;
import br.com.webcars.dtos.CarResponseDTO;
import br.com.webcars.repositories.CarRepository;

@Service
public class CarService
{

	@Autowired
	private CarRepository repository;

	public List<CarResponseDTO> list(CarFilterDTO filter)
	{
		var example = Example.of(filter.to());

		var cars = repository.findAll(example);

		return CarResponseDTO.from(cars);
	}

}
