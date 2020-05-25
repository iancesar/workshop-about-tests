package br.com.webcars.repositories.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.webcars.entities.Car;
import br.com.webcars.entities.Owner;

public interface CarRepository extends JpaRepository<Car, Long>, CustomCarRepository
{

	@Query("select c from Car c where c.owner = :owner and c not in :carNotIn")
	List<Car> findOthersCars(@Param("owner") Owner owner, @Param("carNotIn") Car carNotIn);

}
