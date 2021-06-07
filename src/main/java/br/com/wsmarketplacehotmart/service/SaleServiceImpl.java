package br.com.wsmarketplacehotmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wsmarketplacehotmart.model.Sale;
import br.com.wsmarketplacehotmart.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	public SaleRepository saleRepository;
	
	public Sale insert(Sale saleProduct) {
		return saleRepository.save(saleProduct);
	}
	
	public long findProductSalesQuantity(Integer identifier) {
		return saleRepository.amountOfSales(identifier);
	}
}
