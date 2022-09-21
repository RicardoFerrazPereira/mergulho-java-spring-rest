package com.sourprojects.sourlog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sourprojects.sourlog.domain.model.Cliente;
import com.sourprojects.sourlog.domain.model.Entrega;
import com.sourprojects.sourlog.domain.model.StatusEntrega;
import com.sourprojects.sourlog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

		private CatalagoClienteService catalagoClienteService;
		private EntregaRepository entregaRepository;
		
		@Transactional
		public Entrega solicitar(Entrega entrega) {
			Cliente cliente = catalagoClienteService.buscar(entrega.getCliente().getId());					
			
			entrega.setCliente(cliente);
			entrega.setStatus(StatusEntrega.PENDENTE);
			entrega.setDataPedido(OffsetDateTime.now());
			
			return entregaRepository.save(entrega);
		}
		
}
