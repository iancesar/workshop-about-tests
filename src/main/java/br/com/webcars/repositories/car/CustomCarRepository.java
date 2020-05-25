package br.com.webcars.repositories.car;

import java.util.List;

import org.springframework.data.domain.Example;

import br.com.webcars.entities.Car;

public interface CustomCarRepository
{

	List<Car> findAllJoinOwner(Example<Car> example);

}
