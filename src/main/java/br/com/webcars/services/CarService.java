package br.com.webcars.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.webcars.dtos.CarDetailDTO;
import br.com.webcars.dtos.CarFilterDTO;
import br.com.webcars.dtos.CarResponseDTO;
import br.com.webcars.entities.Car;
import br.com.webcars.repositories.car.CarRepository;

@Service
public class CarService
{

	@Autowired
	private CarRepository	repository;

	@Autowired
	private ModelMapper		mapper;

	public List<CarResponseDTO> list(CarFilterDTO filter)
	{
		var car = mapper.map(filter, Car.class);

		var example = Example.of(car);
		var cars = repository.findAllJoinOwner(example);

		return CarResponseDTO.from(cars);
	}

	public CarDetailDTO getDetail(Long id)
	{
		Car car = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		List<Car> othersCars = repository.findOthersCars(car.getOwner(), car);

		CarDetailDTO dto = CarDetailDTO//
			.builder()//
			.car(CarResponseDTO.from(car))//
			.othersCars(CarResponseDTO.from(othersCars))//
			.build();

		return dto;
	}

}
