package com.br.wsmarketplacehotmart.util;

public class CalculaleScore {
	public Integer calcule(Double productRatingAverage, Integer quantityOfSalesDays, Integer amountOfProductCategoryNews) {
		return Math.toIntExact(Math.round(productRatingAverage)) + quantityOfSalesDays + amountOfProductCategoryNews;
	}

	/*
	 * X = Média de avaliação do produto nos últimos 12 meses 
	 * Y = Quantidade de vendas/dias que o produto existe 
	 * Z = Quantidade de notícias da categoria do produto no dia corrente
	 */
}
