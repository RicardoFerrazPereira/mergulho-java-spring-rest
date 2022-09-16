package com.sourprojects.sourlog.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourprojects.sourlog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	// Query method - métodos de consultas
	
	List<Cliente> findByNome(String nome);

}
