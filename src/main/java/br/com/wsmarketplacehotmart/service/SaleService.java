package br.com.wsmarketplacehotmart.service;

import br.com.wsmarketplacehotmart.model.Sale;

public interface SaleService {
	
	public Sale insert(Sale saleProduct);
	public long findProductSalesQuantity(Integer identifier);
}
