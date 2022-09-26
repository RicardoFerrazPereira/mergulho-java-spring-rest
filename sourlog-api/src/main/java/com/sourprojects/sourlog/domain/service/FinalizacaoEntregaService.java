package com.sourprojects.sourlog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sourprojects.sourlog.domain.model.Entrega;
import com.sourprojects.sourlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	
	private BuscaEntregaService buscaEntregaService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
	
	

}
