package com.br.wsmarketplacehotmart.util;

/*
 * X = Média de avaliação do produto nos últimos 12 meses 
 * Y = Quantidade de vendas/dias que o produto existe 
 * Z = Quantidade de notícias da categoria do produto no dia corrente
 */
public class Score {
	public long calcule(Double productRatingAverage, long quantityOfSalesDays, long amountOfProductCategoryNews) {
		return Math.toIntExact(Math.round(productRatingAverage)) + quantityOfSalesDays + amountOfProductCategoryNews;
	}

}
