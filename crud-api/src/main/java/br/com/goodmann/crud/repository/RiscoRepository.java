package br.com.goodmann.crud.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.goodmann.crud.model.Risco;

@Repository
public interface RiscoRepository extends CrudRepository<Risco, Integer> {

	@Query
	public Risco findByRiscoIgnoreCase(String risco);

}
