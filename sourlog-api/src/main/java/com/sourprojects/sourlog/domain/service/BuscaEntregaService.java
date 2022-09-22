package com.sourprojects.sourlog.domain.service;

import org.springframework.stereotype.Service;

import com.sourprojects.sourlog.domain.exception.EntidadeNaoEncontradaException;
import com.sourprojects.sourlog.domain.model.Entrega;
import com.sourprojects.sourlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
	

}
