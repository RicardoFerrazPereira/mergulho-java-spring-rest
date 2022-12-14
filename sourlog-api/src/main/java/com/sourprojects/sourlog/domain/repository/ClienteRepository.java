package com.sourprojects.sourlog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourprojects.sourlog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	// Query method - métodos de consultas
	
	List<Cliente> findByNome(String nome);
	List<Cliente> findByNomeContaining(String nome);
	
	// consulta de cliente por email
	Optional<Cliente> findByEmail(String email);

}
