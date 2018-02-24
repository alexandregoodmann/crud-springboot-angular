package br.com.goodmann.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.goodmann.crud.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
