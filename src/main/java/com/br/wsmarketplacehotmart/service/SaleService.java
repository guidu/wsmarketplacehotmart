package com.br.wsmarketplacehotmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.wsmarketplacehotmart.model.Sale;
import com.br.wsmarketplacehotmart.repository.SaleRepository;

@Service
public class SaleService {
	@Autowired
	public SaleRepository saleRepository;
	
	public Sale salve(Sale saleProduct) {
		return saleRepository.save(saleProduct);
	}
	
	public long findProductSalesQuantity(Integer identifier) {
		return saleRepository.amountOfSales(identifier);
	}
}
