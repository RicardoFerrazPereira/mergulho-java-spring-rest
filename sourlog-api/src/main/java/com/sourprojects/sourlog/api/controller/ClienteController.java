package com.sourprojects.sourlog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourprojects.sourlog.domain.model.Cliente;
import com.sourprojects.sourlog.domain.repository.ClienteRepository;

@RestController
public class ClienteController {
	
//	@PersistenceContext
//	private EntityManager manager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
//	@GetMapping("/clientes")
//	public List<Cliente> listar() {
//		return manager.createQuery("from Cliente", Cliente.class)
//				.getResultList();		
//	}

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
}
