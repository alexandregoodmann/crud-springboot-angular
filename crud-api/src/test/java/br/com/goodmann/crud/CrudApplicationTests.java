package br.com.goodmann.crud;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.goodmann.crud.repository.ClienteRepository;
import br.com.goodmann.crud.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudApplicationTests {

	@Autowired
	private ClienteService service;

	@Autowired
	private ClienteRepository repo;


}
