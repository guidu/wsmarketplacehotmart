package com.br.wsmarketplacehotmart.service;

import com.br.wsmarketplacehotmart.model.Sale;

public interface SaleService {
	
	public Sale insert(Sale saleProduct);
	public long findProductSalesQuantity(Integer identifier);
}
