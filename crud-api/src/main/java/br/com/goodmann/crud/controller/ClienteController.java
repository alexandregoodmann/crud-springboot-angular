package br.com.goodmann.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.goodmann.crud.exception.NotAcceptableException;
import br.com.goodmann.crud.exception.NotFoundException;
import br.com.goodmann.crud.model.Cliente;
import br.com.goodmann.crud.repository.ClienteRepository;
import br.com.goodmann.crud.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping(value = "/crud/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping(value = "/{id}")
	public Cliente findCliente(@PathVariable(name = "id") Integer id) {

		Cliente cliente = this.clienteRepository.findOne(id);
		if (cliente == null) {
			throw new NotFoundException();
		}
		return cliente;
	}

	@GetMapping
	public List<Cliente> findAllCliente() {
		return (List<Cliente>) this.clienteRepository.findAll();
	}

	@PostMapping(value = "/salvar")
	public Cliente salvarCliente(@Valid @RequestBody Cliente cliente) throws Exception {
		try {
			return this.service.salvarCliente(cliente);
		} catch (Exception e) {
			throw new NotAcceptableException(e.getMessage());
		}
	}

}
