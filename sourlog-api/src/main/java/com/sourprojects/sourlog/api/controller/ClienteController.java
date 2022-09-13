package com.sourprojects.sourlog.api.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourprojects.sourlog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Farroch");
		cliente1.setEmail("farrock@gmail.com");
		cliente1.setTelefone("21 98888-7777");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Eddie");
		cliente2.setEmail("eddie@gmail.com");
		cliente2.setTelefone("21 98888-2222");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
