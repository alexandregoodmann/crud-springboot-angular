package br.com.goodmann.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goodmann.crud.exception.BusinessException;
import br.com.goodmann.crud.model.Cliente;
import br.com.goodmann.crud.model.Risco;
import br.com.goodmann.crud.repository.ClienteRepository;
import br.com.goodmann.crud.repository.RiscoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private RiscoRepository riscoRepository;

	public Cliente salvarCliente(Cliente cliente) {

		String risco = cliente.getRisco().getRisco();
		Risco ris = this.riscoRepository.findByRiscoIgnoreCase(risco);

		if (ris == null) {
			throw new BusinessException("O risco informado não é válido ou não contém na base de dados: " + risco);
		}

		cliente.setRisco(ris);

		if ("A".equalsIgnoreCase(risco)) {
			cliente.setTaxaJuros(0d);
		} else if ("B".equalsIgnoreCase(risco)) {
			cliente.setTaxaJuros(10d);
		} else if ("C".equalsIgnoreCase(risco)) {
			cliente.setTaxaJuros(20d);
		}

		return this.clienteRepository.save(cliente);
	}

}
