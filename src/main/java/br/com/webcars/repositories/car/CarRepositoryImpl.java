package br.com.webcars.repositories.car;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.Example;

import br.com.webcars.entities.Car;

public class CarRepositoryImpl implements CustomCarRepository
{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Car> findAllJoinOwner(Example<Car> example)
	{

		var cb = entityManager.getCriteriaBuilder();
		var query = cb.createQuery(Car.class);

		var root = query.from(Car.class);
		root.fetch("owner");

		Predicate predicate = cb.conjunction();

		var car = example.getProbe();

		Optional.ofNullable(car.getBrand()).ifPresent(brand -> predicate.getExpressions().add(cb.equal(root.get("brand"), brand)));
		Optional.ofNullable(car.getModel()).ifPresent(brand -> predicate.getExpressions().add(cb.equal(root.get("model"), brand)));
		Optional.ofNullable(car.getYear()).ifPresent(brand -> predicate.getExpressions().add(cb.equal(root.get("year"), brand)));
		Optional.ofNullable(car.getPrice()).ifPresent(brand -> predicate.getExpressions().add(cb.equal(root.get("price"), brand)));

		query.select(root).where(predicate);

		return entityManager.createQuery(query).getResultList();
	}
}
