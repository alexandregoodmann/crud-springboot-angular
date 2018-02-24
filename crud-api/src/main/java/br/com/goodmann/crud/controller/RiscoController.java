package br.com.goodmann.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goodmann.crud.exception.NotFoundException;
import br.com.goodmann.crud.model.Risco;
import br.com.goodmann.crud.repository.RiscoRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/crud/risco")
public class RiscoController {

	@Autowired
	private RiscoRepository riscoRepository;

	@GetMapping
	public List<Risco> risco() {
		List<Risco> lista = (List<Risco>) this.riscoRepository.findAll();
		if (lista.isEmpty()) {
			throw new NotFoundException();
		}
		return lista;
	}

}
