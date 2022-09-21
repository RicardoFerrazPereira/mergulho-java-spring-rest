package com.sourprojects.sourlog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sourprojects.sourlog.api.assembler.EntregaAssembler;
import com.sourprojects.sourlog.api.model.EntregaModel;
import com.sourprojects.sourlog.api.model.input.EntregaInput;
import com.sourprojects.sourlog.domain.model.Entrega;
import com.sourprojects.sourlog.domain.repository.EntregaRepository;
import com.sourprojects.sourlog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private EntregaAssembler entregaAssembler;;
	
	
	// Sem DTO
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
//		return solicitacaoEntregaService.solicitar(entrega);
//	}
	
	// Com DTO
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		return entregaAssembler.toModel(entregaSolicitada);
	}
	
	// Sem DTO
	
//	@GetMapping
//	public List<Entrega> listar() {
//		return entregaRepository.findAll();
//	}
	
	// ComDTO
	
	@GetMapping
	public List<EntregaModel> listar() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}
	
	// Antes do DTO
	
//	@GetMapping("/{entregaId}")
//	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
//		return entregaRepository.findById(entregaId)
//				.map(ResponseEntity::ok)
//				.orElse(ResponseEntity.notFound().build());
//		
//	}
	
	// DTO

//	@GetMapping("/{entregaId}")
//	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
//		return entregaRepository.findById(entregaId)
//				.map(entrega -> {
//					EntregaModel entregaModel= new EntregaModel();
//					entregaModel.setId(entrega.getId());
//					entregaModel.setNomeCliente(entrega.getCliente().getNome());
//					entregaModel.setDestinatario(new DestinatarioModel());
//					entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
//					entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
//					entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
//					entregaModel.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
//					entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
//					entregaModel.setTaxa(entrega.getTaxa());
//					entregaModel.setStatus(entrega.getStatus());
//					entregaModel.setDataPedido(entrega.getDataPedido());
//					entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());
//					
//					return ResponseEntity.ok(entregaModel);					
//				})
//				.orElse(ResponseEntity.notFound().build());
//		
//	}
	
	// Converter para DTO com a biblioteca "ModelMapper"
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))				
				.orElse(ResponseEntity.notFound().build());		
	}
	
	
	
}
