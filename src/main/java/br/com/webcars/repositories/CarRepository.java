package br.com.webcars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.webcars.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long>
{

}
