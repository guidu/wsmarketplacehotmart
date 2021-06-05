package com.br.wsmarketplacehotmart.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.wsmarketplacehotmart.dto.SaleDTO;
import com.br.wsmarketplacehotmart.model.Sale;
import com.br.wsmarketplacehotmart.service.SaleService;
import com.br.wsmarketplacehotmart.view.SaletForm;

@RestController
@RequestMapping("/api/wsmarkeplaehotmart/sale")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@PostMapping("/insert")
	@Transactional
	public ResponseEntity<SaleDTO> create(@RequestBody SaletForm saleForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Sale sale = saleForm.convertSale();
		saleService.insert(sale);
		URI uri = uriComponentsBuilder.path("/salelist/{id}").buildAndExpand(sale.getIdentifier()).toUri();
		return ResponseEntity.created(uri).body(new SaleDTO(sale));
	}
}
